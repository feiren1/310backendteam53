package csci310.security;

import csci310.models.UserPrincipal;
import csci310.service.UserDetailService;
import csci310.service.UserService;
import csci310.web.UserController;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JwtTokenFilterTest {

    @InjectMocks
    JwtTokenFilter jwtTokenFilter;

    @Mock
    UserDetailService userDetailService;

    @Mock
    JwtUtils jwtUtils;

    @Mock
    UserService userService;

    @Before
    public void setUp() throws Exception {
        jwtTokenFilter = new JwtTokenFilter();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doFilterInternal() throws ServletException, IOException {
        HttpSession session = mock(HttpSession.class);
        // Mock up HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        // Mock up HttpServletResponse
        HttpServletResponse response = mock(HttpServletResponse.class);
        // Mock up FilterChain
        FilterChain filterChain = mock(FilterChain.class);
        String jwt = Jwts.builder()
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+1800000))
                .signWith(SignatureAlgorithm.HS512,"secretKey")
                .compact();
        UserPrincipal userPrincipal = new UserPrincipal("user","password");

        when(jwtUtils.parseJwt(request)).thenReturn(jwt);
        when(jwtUtils.validateJwtToken(jwt)).thenReturn(true);
        when(jwtUtils.getUserNameFromJwtToken(jwt)).thenReturn("user");
        when(userDetailService.loadUserByUsername("user")).thenReturn(userPrincipal);

        jwtTokenFilter.doFilterInternal(request, response, filterChain);
        verify(jwtUtils).parseJwt(request);
        verify(jwtUtils).validateJwtToken(jwt);
        verify(jwtUtils).getUserNameFromJwtToken(jwt);
        verify(userDetailService).loadUserByUsername("user");

        assertEquals(0, response.getStatus());
    }

    @Test
    public void doFilterInternal2() throws ServletException, IOException {
        HttpSession session = mock(HttpSession.class);
        // Mock up HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        // Mock up HttpServletResponse
        HttpServletResponse response = mock(HttpServletResponse.class);
        // Mock up FilterChain
        FilterChain filterChain = mock(FilterChain.class);

        when(jwtUtils.parseJwt(request)).thenReturn(null);
        jwtTokenFilter.doFilterInternal(request, response, filterChain);
        verify(jwtUtils).parseJwt(request);

        assertEquals(0, response.getStatus());
    }

    @Test
    public void doFilterInternal3() throws ServletException, IOException {
        HttpSession session = mock(HttpSession.class);
        // Mock up HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        // Mock up HttpServletResponse
        HttpServletResponse response = mock(HttpServletResponse.class);
        // Mock up FilterChain
        FilterChain filterChain = mock(FilterChain.class);
        String jwt = Jwts.builder()
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()))
                .signWith(SignatureAlgorithm.HS512,"wrongKey")
                .compact();

        when(jwtUtils.parseJwt(request)).thenReturn(jwt);
        when(jwtUtils.validateJwtToken(jwt)).thenReturn(false);
        jwtTokenFilter.doFilterInternal(request, response, filterChain);
        verify(jwtUtils).parseJwt(request);
        verify(jwtUtils).validateJwtToken(jwt);

        assertEquals(0, response.getStatus());
    }

    @Test
    public void getAuthentication(){
        UserPrincipal userPrincipal = new UserPrincipal("user","password");
        String jwtToken = Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+1800000))
                .signWith(SignatureAlgorithm.HS512,"secretKey")
                .compact();

        when(jwtUtils.getUserNameFromJwtToken(jwtToken)).thenReturn("user");
        when(userDetailService.loadUserByUsername("user")).thenReturn(userPrincipal);
        Authentication authentication = jwtTokenFilter.getAuthentication(jwtToken);
        verify(jwtUtils).getUserNameFromJwtToken(jwtToken);
        verify(userDetailService).loadUserByUsername("user");

        UserPrincipal userPrincipal1 = (UserPrincipal) authentication.getPrincipal();
        assertEquals("user",userPrincipal1.getUsername());
        assertEquals("password",userPrincipal1.getPassword());
    }
}
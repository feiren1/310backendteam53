package csci310.security;

import csci310.models.UserPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JwtUtilsTest {

    JwtUtils jwtUtils;
    /*private class CustomAuthenticationManager implements AuthenticationManager{

    }*/
    AuthenticationManager authenticationManager;
    Authentication authentication;

    @Before
    public void setUp() throws Exception {
        jwtUtils = new JwtUtils();
        //authenticationManager = new ProviderManager();
    }

    @Test
    public void generateJwtToken() {
        //authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("user","password"));
        Authentication authentication = mock(Authentication.class);
        UserPrincipal userPrincipal = new UserPrincipal("user","password");
        when(authentication.getPrincipal()).thenReturn(userPrincipal);
        String jwt = jwtUtils.generateJwtToken(authentication);
        verify(authentication).getPrincipal();
        assertNotNull(jwt);
    }

    @Test
    public void getUserNameFromJwtToken() {
        //authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("user","password"));
        Authentication authentication = mock(Authentication.class);
        UserPrincipal userPrincipal = new UserPrincipal("user","password");
        when(authentication.getPrincipal()).thenReturn(userPrincipal);
        String jwt = jwtUtils.generateJwtToken(authentication);
        verify(authentication).getPrincipal();
        String username = jwtUtils.getUserNameFromJwtToken(jwt);
        assertEquals("user",username);
    }

    @Test
    public void parseJwt() {
        HttpSession session = mock(HttpSession.class);

        // Mock up HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        String header;
        header = "Bearer authorized";
        when(request.getHeader("Authorization")).thenReturn(header);
        assertEquals("authorized",jwtUtils.parseJwt(request));
        verify(request).getHeader("Authorization");
    }

    @Test
    public void parseJwt2() {
        HttpSession session = mock(HttpSession.class);

        // Mock up HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        String header;
        header = "unauthorized";
        when(request.getHeader("Authorization")).thenReturn(header);
        assertEquals(null,jwtUtils.parseJwt(request));
        verify(request).getHeader("Authorization");
    }

    @Test
    public void parseJwt3() {
        HttpSession session = mock(HttpSession.class);

        // Mock up HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        String header;
        header = "";
        when(request.getHeader("Authorization")).thenReturn(header);
        assertEquals(null,jwtUtils.parseJwt(request));
        verify(request).getHeader("Authorization");
    }

    @Test
    public void validateJwtToken() {
        //authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("user","password"));
        Authentication authentication = mock(Authentication.class);
        UserPrincipal userPrincipal = new UserPrincipal("user","password");
        when(authentication.getPrincipal()).thenReturn(userPrincipal);
        String jwt = jwtUtils.generateJwtToken(authentication);
        verify(authentication).getPrincipal();
        assertTrue(jwtUtils.validateJwtToken(jwt));
    }

    @Test
    public void validateJwtToken1(){
        UserPrincipal userPrincipal = new UserPrincipal("user","password");
        String jwt = Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+1800000))
                .signWith(SignatureAlgorithm.HS512,"wrongKey")
                .compact();
        assertFalse(jwtUtils.validateJwtToken(jwt));
        jwt = Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()))
                .signWith(SignatureAlgorithm.HS512,"secretKey")
                .compact();
        assertFalse(jwtUtils.validateJwtToken(jwt));
        jwt = "malformed";
        assertFalse(jwtUtils.validateJwtToken(jwt));
        jwt = Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+1800000))
                .compact();
        assertFalse(jwtUtils.validateJwtToken(jwt));
        assertFalse(jwtUtils.validateJwtToken(null));
    }
}
package csci310.security;

import io.cucumber.java.bs.A;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AuthEntryPointJwtTest {

    AuthEntryPointJwt authEntryPointJwt;

    @Before
    public void setUp() throws Exception {
        authEntryPointJwt = new AuthEntryPointJwt();
    }

    @Test
    public void commence() throws IOException, ServletException {
        HttpSession session = mock(HttpSession.class);

        // Mock up HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);


        HashMap<String,String[]> params = new HashMap<>();


        // Mock up HttpServletResponse
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);


        AuthenticationException authenticationException = new InsufficientAuthenticationException("exception");

        authEntryPointJwt.commence(request,response,authenticationException);

        assertEquals(0, response.getStatus());


    }
}
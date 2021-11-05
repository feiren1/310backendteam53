package csci310.security;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    public Logger getLogger() {
        return logger;
    }

    private HttpServletRequest request;
    private HttpServletResponse response;
    private AuthenticationException authenticationException;

    public AuthEntryPointJwt() {}
    public AuthEntryPointJwt(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) {
        this.request = request;
        this.response = response;
        this.authenticationException = authenticationException;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }

}
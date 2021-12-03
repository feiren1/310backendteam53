package csci310.security;

import csci310.service.UserDetailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class WebSecurityConfigTest {

    WebSecurityConfig webSecurityConfig;

    @Before
    public void setUp() throws Exception {
        webSecurityConfig = new WebSecurityConfig();
    }

    @Test
    public void testConfigure() throws Exception {
        ObjectPostProcessor<Object> objectPostProcessor = new ObjectPostProcessor<Object>() {
            @Override
            public <O extends Object> O postProcess(O o) {
                return null;
            }
        };
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        webSecurityConfig.configure(authenticationManagerBuilder);
        assertFalse(authenticationManagerBuilder.isConfigured());
    }

    @Test
    public void testConfigure1() throws Exception {
        ObjectPostProcessor<Object> objectPostProcessor = new ObjectPostProcessor<Object>() {
            @Override
            public <O extends Object> O postProcess(O o) {
                return null;
            }
        };
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        Map<Class<?>,Object> sharedObjects = new HashMap<Class<?>, Object>();
        HttpSecurity httpSecurity = new HttpSecurity(objectPostProcessor,authenticationManagerBuilder, sharedObjects);
        webSecurityConfig.configure(httpSecurity);
        assertEquals("org.springframework.security.config.annotation.web.builders.HttpSecurity", httpSecurity.toString().substring(0,72));
    }

    @Test
    public void testNewJwtTokenFilter() {
        JwtTokenFilter jwtTokenFilter = webSecurityConfig.newJwtTokenFilter();
        assertNotNull(jwtTokenFilter);
        assertEquals("csci310.security.JwtTokenFilter", jwtTokenFilter.getClass().getName());
    }

    /*@Test
    public void testAuthenticationManagerBean() throws Exception {
        AuthenticationManager authenticationManager = webSecurityConfig.authenticationManagerBean();
        assertNotNull(authenticationManager);
        assertEquals("", authenticationManager.getClass().getName());

    }*/

    @Test
    public void testPasswordEncoder() {
        PasswordEncoder passwordEncoder = webSecurityConfig.passwordEncoder();
        assertNotNull(passwordEncoder);
        assertEquals("org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder", passwordEncoder.getClass().getName());
    }
}
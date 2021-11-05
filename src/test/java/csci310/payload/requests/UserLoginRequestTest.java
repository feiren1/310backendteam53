package csci310.payload.requests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserLoginRequestTest {

    UserLoginRequest userLoginRequest;

    @Before
    public void setUp() throws Exception {
        userLoginRequest = new UserLoginRequest();
    }

    @Test
    public void getUsername() {
        userLoginRequest.setUsername("user");
        assertEquals("user", userLoginRequest.getUsername());
    }

    @Test
    public void getPassword() {
        userLoginRequest.setPassword("pw");
        assertEquals("pw", userLoginRequest.getPassword());
    }

    @Test
    public void setUsername() {
        userLoginRequest.setUsername("user");
        assertEquals("user", userLoginRequest.getUsername());
    }

    @Test
    public void setPassword() {
        userLoginRequest.setPassword("pw");
        assertEquals("pw", userLoginRequest.getPassword());
    }
}
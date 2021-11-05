package csci310.payload.responses;

import org.junit.Before;

import static org.junit.Assert.*;

public class JwtResponseTest {

    JwtResponse jwtResponse;
    @Before
    public void setUp() throws Exception {
        jwtResponse = new JwtResponse("response message","jwt");
    }
}
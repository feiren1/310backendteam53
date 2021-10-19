package csci310.payload.responses;

public class JwtResponse {
    private String responseMessage;
    private String jwt;
    public JwtResponse(String responseMessage,String jwt){
        this.responseMessage = responseMessage;
        this.jwt = jwt;
    }
}

package csci310.payload.requests;


public class UserProposalRequest {
    private String Uname;

    public String getKey() {
        return Uname;
    }
    public void setName(String newname) {
        this.Uname = newname;
    }
}
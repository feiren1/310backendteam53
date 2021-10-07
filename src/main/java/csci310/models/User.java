package csci310.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    Long id;

    @Indexed(unique = true)
    private String username;

    private String password;
    List<Integer> received_proposal_ids;
    List<Integer> hosted_proposal_ids;
    List<Integer> finalized_proposal_ids;


    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        received_proposal_ids = new ArrayList<Integer>();
        hosted_proposal_ids = new ArrayList<Integer>();
        finalized_proposal_ids = new ArrayList<Integer>();
    }

    public Long getId(){return id;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}

    public List<Integer> getReceivedProposalIds(){return received_proposal_ids;}
    public List<Integer> getHostedProposalIds(){return hosted_proposal_ids;}
    public List<Integer> getFinalizedProposalIds(){return finalized_proposal_ids;}

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s']",
                id, username, password);
    }
}


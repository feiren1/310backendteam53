package csci310.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "users")
public class User {
    //data members
    @Id
    public int uid;

    @Indexed(unique = true)
    private String username;

    private String password;
    private List<Integer> received_proposal_ids;
    private List<Integer> hosted_proposal_ids;
    private List<Integer> finalized_proposal_ids;


    //constructors
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        received_proposal_ids = new ArrayList<Integer>();
        hosted_proposal_ids = new ArrayList<Integer>();
        finalized_proposal_ids = new ArrayList<Integer>();

        UUID newId = UUID.randomUUID();
        uid = newId.toString().hashCode();
    }

    //getters
    public int getId(){return uid;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public List<Integer> getReceivedProposalIds(){return received_proposal_ids;}
    public List<Integer> getHostedProposalIds(){return hosted_proposal_ids;}
    public List<Integer> getFinalizedProposalIds(){return finalized_proposal_ids;}


    //setters
    public void setId(int uid){this.uid = uid;}
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
    public void setReceivedProposalIds(List<Integer> received_ids){received_proposal_ids = received_ids;}
    public void setHostedProposalIds(List<Integer> hosted_ids){hosted_proposal_ids = hosted_ids;}
    public void setFinalizedProposalIds(List<Integer> finalized_ids){finalized_proposal_ids = finalized_ids;}


    //methods
    public void addReceivedProposal(Integer received_proposal_id){received_proposal_ids.add(received_proposal_id);}
    public void addHostedProposal(Integer hosted_proposal_id){hosted_proposal_ids.add(hosted_proposal_id);}
    public void addFinalizedProposal(Integer finalized_proposal_id){finalized_proposal_ids.add(finalized_proposal_id);}
    public void removeReceivedProposal(Integer received_proposal_id){received_proposal_ids.remove(Integer.valueOf(received_proposal_id));}
    public void removeHostedProposal(Integer hosted_proposal_id){hosted_proposal_ids.remove(Integer.valueOf(hosted_proposal_id));}
    public void removeFinalizedProposal(Integer finalized_proposal_id){finalized_proposal_ids.remove(Integer.valueOf(finalized_proposal_id));}


    //toString
    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s']",
                uid, username, password);
    }
}

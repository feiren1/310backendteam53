package csci310.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "proposals")
public class Proposal {
    @Id
    Long id;

    @Indexed(unique = true)
    private Long host_id;

    private int finalized;
    private int status;

    List<Integer> users;
    List<Event> events;

    public Proposal() {}

    public Proposal(Long host_id) {
        this.host_id = host_id;
        finalized = 0;
        status = -1;
        users = new ArrayList<Integer>();
        events = new ArrayList<Event>();
    }

    //getters
    public Long getId(){return id;}
    public Long getHostId(){return host_id;}
    public int getFinalized(){return finalized;}

    public List<Integer> getUsers(){return users;}
    public List<Event> getEvents(){return events;}

    //setters
    public void finalizeProposal(){finalized = 1;}

    //methods
    public void addUser(int user_id){users.add(user_id);}
    public void addEvent(String url){
        Event newEvent = new Event(url);
        events.add(newEvent);
    }
    public void addUserResponses(User user, String event_url, int availability, int rating){
        //todo
    }

    @Override
    public String toString() {
        return String.format(
                "Proposal[id=%s, host id='%s']",
                id, host_id);
    }
}

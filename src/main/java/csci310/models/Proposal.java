package csci310.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "proposals")
public class Proposal {
    //data members
    @Id
    private int uid;

    @Indexed(unique = true)
    private int host_id;

    private int finalized;
    private int status;

    private List<Integer> users;
    private List<Event> events;


    //constructors
    public Proposal() {}

    public Proposal(int host_id) {
        this.host_id = host_id;
        finalized = 0;
        status = -1;
        users = new ArrayList<Integer>();
        events = new ArrayList<Event>();

        UUID newId = UUID.randomUUID();
        uid = newId.toString().hashCode();
    }


    //getters
    public int getId(){return uid;}
    public int getHostId(){return host_id;}
    public int getFinalized(){return finalized;}
    public int getStatus(){return status;}
    public List<Integer> getUsers(){return users;}
    public List<Event> getEvents(){return events;}


    //setters
    public void setId(int uid){this.uid = uid;}
    public void setHostId(int host_id){this.host_id = host_id;}
    public void setFinalized(int f){finalized = f;}
    public void setStatus(int s){status = s;}
    public void setUsers(List<Integer> userList){users = userList;}
    public void setEvents(List<Event> eventList){events = eventList;}


    //methods
    public boolean finalizeProposal(){
        if(finalized == 1){return false;}
        else{
            finalized = 1;
            return true;
        }
    }
    public void addUser(int user_id){users.add(user_id);}
    public void addEvent(String url){
        Event newEvent = new Event(url);
        events.add(newEvent);
    }
    /*public void addUserResponses(User user, String event_url, int availability, int rating){
        //todo
    }*/


    //toString
    @Override
    public String toString() {
        return String.format(
                "Proposal[id=%s, host id='%s']",
                uid, host_id);
    }
}
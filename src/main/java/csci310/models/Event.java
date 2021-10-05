package csci310.models;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private String url;

    private Map<Integer,Integer> availabilities;
    private Map<Integer,Integer> ratings;

    public Event() {}

    public Event(String url) {
        this.url = url;
        availabilities = new HashMap<Integer,Integer>();
        ratings = new HashMap<Integer,Integer>();
    }

    //getters
    public String getUrl(){return url;}
    public Map<Integer,Integer> getAvailabilities(){return availabilities;}
    public Map<Integer, Integer> getRatings() {return ratings;}

    //methods
    public void addUserInfo(int user_id, int availability, int rating){
        availabilities.putIfAbsent(user_id,availability);
        ratings.putIfAbsent(user_id,rating);
    }

    @Override
    public String toString() {
        return String.format(
                "Event[url=%s]",
                url);
    }
}
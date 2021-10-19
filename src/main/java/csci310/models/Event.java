package csci310.models;

import java.util.HashMap;
import java.util.Map;

public class Event {
    //data members
    private String url;
    private Map<Integer,Integer> availabilities;
    private Map<Integer,Integer> ratings;


    public Event(String url) {
        this.url = url;
        availabilities = new HashMap<Integer,Integer>();
        ratings = new HashMap<Integer,Integer>();
    }

    //getters
    public String getUrl(){return url;}
    public Map<Integer,Integer> getAvailabilities(){return availabilities;}
    public Map<Integer, Integer> getRatings() {return ratings;}


    //setters
    public void setUrl(String url){this.url = url;}
    public void setAvailabilities(Map<Integer,Integer> availabilityMap){availabilities = availabilityMap;}
    public void setRatings(Map<Integer,Integer> ratingMap){ratings = ratingMap;}


    //methods
    public void addUserInfo(int user_id, int availability, int rating){
        availabilities.putIfAbsent(user_id,availability);
        ratings.putIfAbsent(user_id,rating);
    }


    //toString
    @Override
    public String toString() {
        return String.format(
                "Event[url=%s]",
                url);
    }
}


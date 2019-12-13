package ufpe.mobggfl.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.UUID;


public class User {
    private String name;
    private UUID id;
    private String username;
    private String password;
    private ArrayList<Group> groups;
    private ArrayList<Event> events;

    public User(@JsonProperty("name") String name, @JsonProperty("username") String username, @JsonProperty("passoword") String password){
        this.name = name;
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.groups = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }
    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}

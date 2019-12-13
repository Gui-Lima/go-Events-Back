package ufpe.mobggfl.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.UUID;

public class Group {
  private String name;
  private UUID id;
  private UUID ownerId;
  private ArrayList<Event> events;

  public Group(@JsonProperty("name") String name,@JsonProperty("ownerid") UUID ownerId){
    this.name = name;
    this.ownerId = ownerId;
    this.id = UUID.randomUUID();
    this.events = new ArrayList<>();
  }

  public Group(){}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
  }

  public ArrayList<Event> getEvents() {
    return events;
  }

  public void setEvents(ArrayList<Event> events) {
    this.events = events;
  }
}

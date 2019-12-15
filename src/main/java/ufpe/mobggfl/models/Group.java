package ufpe.mobggfl.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.UUID;

public class Group {
  private String name;
  private UUID uuid;
  private UUID ownerId;
  private String ownerName;
  private ArrayList<Event> events;

  public Group(@JsonProperty("name") String name,@JsonProperty("ownerid") UUID ownerId, @JsonProperty("ownername") String ownerName){
    this.name = name;
    this.ownerId = ownerId;
    this.ownerName = ownerName;
    this.uuid = UUID.randomUUID();
    this.events = new ArrayList<>();
  }

  public Group(){}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
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

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }
}

package ufpe.mobggfl.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Event {
  private String name;
  private UUID uuid;
  private int lat;
  private int log;
  private UUID group_id;
  private String group_name;

  public Event(@JsonProperty("name")String name,@JsonProperty("lat") int lat,@JsonProperty("long") int log,
               @JsonProperty("group_id") UUID group_id, @JsonProperty("group_name") String groupName){
    this.name = name;
    this.uuid = UUID.randomUUID();
    this.lat = lat;
    this.log = log;
    this.group_id = group_id;
    this.group_name = groupName;
  }

  public Event(){}

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

  public int getLat() {
    return lat;
  }

  public void setLat(int lat) {
    this.lat = lat;
  }

  public int getLog() {
    return log;
  }

  public void setLog(int log) {
    this.log = log;
  }

  public UUID getGroup_id() {
    return group_id;
  }

  public void setGroup_id(UUID group_id) {
    this.group_id = group_id;
  }

  public String getGroup_name() {
    return group_name;
  }

  public void setGroup_name(String group_name) {
    this.group_name = group_name;
  }
}

package ufpe.mobggfl.mappers;

import org.springframework.jdbc.core.RowMapper;
import ufpe.mobggfl.models.Event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class EventRowMapper implements RowMapper<Event> {
  @Override
  public Event mapRow(ResultSet resultSet, int i) throws SQLException {
    Event event = new Event();
    event.setName(resultSet.getString("name"));
    event.setGroup_id(UUID.fromString(resultSet.getString("group_id")));
    event.setLat(Integer.parseInt(resultSet.getString("lat")));
    event.setLog(Integer.parseInt(resultSet.getString("long")));

    return event;
  }
}

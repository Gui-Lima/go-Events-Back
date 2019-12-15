package ufpe.mobggfl.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ufpe.mobggfl.models.Event;

@Repository("event")
public class EventDataAccess implements EventDAO{
  NamedParameterJdbcTemplate template;

  public EventDataAccess(NamedParameterJdbcTemplate template) {
      this.template = template;
    }

  @Override
  public void insertEvent(Event event) {
    final String sql = "insert into tb_event(uuid, name , group_id, lat, long, group_name) values(:uuid,:name,:group_id,:lat,:long, :group_name)";

    KeyHolder holder = new GeneratedKeyHolder();

    Event eventWithId = new Event(event.getName(), event.getLat(), event.getLog(), event.getGroup_id(), event.getGroup_name());

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("uuid", eventWithId.getUuid())
        .addValue("name", eventWithId.getName())
        .addValue("group_id", eventWithId.getGroup_id())
        .addValue("lat", eventWithId.getLat())
        .addValue("long", eventWithId.getLog())
        .addValue("group_name", eventWithId.getGroup_name());

    template.update(sql,param, holder);


  }
}

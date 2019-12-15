package ufpe.mobggfl.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ufpe.mobggfl.mappers.EventRowMapper;
import ufpe.mobggfl.mappers.GroupRowMapper;
import ufpe.mobggfl.mappers.UserRowMapper;
import ufpe.mobggfl.models.Event;
import ufpe.mobggfl.models.Group;
import ufpe.mobggfl.models.User;

import java.util.List;

@Repository("group")
public class GroupDataAccess implements GroupDAO{
  private NamedParameterJdbcTemplate template;

  public GroupDataAccess(NamedParameterJdbcTemplate template) {
    this.template = template;
  }

  @Override
  public void insertGroup(Group group) {
    final String sql = "insert into tb_group(uuid, name , ownerid, ownername) values(:uuid,:name,:ownerid,:ownername)";

    KeyHolder holder = new GeneratedKeyHolder();


    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("uuid", group.getUuid())
        .addValue("name", group.getName())
        .addValue("ownerid", group.getOwnerId())
        .addValue("ownername", group.getOwnerName());

    template.update(sql,param, holder);
  }

  @Override
  public Group getGroupByName(String groupName) {
    return template.query(String.format("select * from tb_group where name = '%s'", groupName),new GroupRowMapper()).get(0);
  }

  @Override
  public List<User> getUsers(Group group) {
    return template.query(
        String.format(
            "select * from tb_user join tb_user_group on tb_user.uuid = tb_user_group.user_id where group_id=%s",group.getUuid()), new UserRowMapper());
  }

  @Override
  public List<Event> getEvents(Group group) {
    return template.query(
        String.format(
            "select * from tb_events where group_id = %s",group.getUuid()), new EventRowMapper());
  }

  @Override
  public List<Group> getGroups() {
    return template.query("select * from tb_group", new GroupRowMapper());
  }

}

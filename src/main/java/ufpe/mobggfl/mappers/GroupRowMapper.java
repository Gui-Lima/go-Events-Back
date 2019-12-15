package ufpe.mobggfl.mappers;

import org.springframework.jdbc.core.RowMapper;
import ufpe.mobggfl.models.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class GroupRowMapper implements RowMapper<Group> {

  @Override
  public Group mapRow(ResultSet resultSet, int i) throws SQLException {
    Group group = new Group();

    group.setUuid(UUID.fromString(resultSet.getString("uuid")));
    group.setName(resultSet.getString("name"));
    group.setOwnerId(UUID.fromString(resultSet.getString("ownerid")));
    group.setOwnerName(resultSet.getString("ownername"));
    return group;
  }
}

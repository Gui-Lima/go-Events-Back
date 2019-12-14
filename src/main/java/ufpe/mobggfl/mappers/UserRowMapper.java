package ufpe.mobggfl.mappers;

import org.springframework.jdbc.core.RowMapper;
import ufpe.mobggfl.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setName(resultSet.getString("name"));
        user.setUsername(resultSet.getString("username"));
        user.setUuid(UUID.fromString(resultSet.getString("uuid")));
        user.setPassword(resultSet.getString("password"));

        return user;
    }
}

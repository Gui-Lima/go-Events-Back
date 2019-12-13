package ufpe.mobggfl.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ufpe.mobggfl.mappers.UserRowMapper;
import ufpe.mobggfl.models.User;
import java.util.List;
import java.util.UUID;

@Repository("postgress")
public class UserDataAccess implements UserDAO {

    NamedParameterJdbcTemplate template;

    public UserDataAccess(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    @Override
    public List<User> findAll() {
        return template.query("select * from tb_user", new UserRowMapper());
    }

    @Override
    public User findUserById(UUID uuid) {
        return template.query(String.format("select * from tb_user where uuid='%s'",uuid), new UserRowMapper()).get(0);
    }

    @Override
    public User findUserByUsername(String username) {
        return template.query(String.format("select * from tb_user where username='%s'",username), new UserRowMapper()).get(0);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return template.query(String.format("select * from tb_user where username='%s' and password=crypt('%s', password)",username, password), new UserRowMapper()).get(0);
    }

    @Override
    public void insertUser(User user) {
        final String sql = "insert into tb_user(uuid, name , username, password) values(:uuid,:name,:username, crypt(:password, gen_salt('bf')))";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("uuid", user.getId())
                .addValue("name", user.getName())
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword());

        template.update(sql,param, holder);
    }

    @Override
    public void updateUser(User user) {
        final String sql = "update tb_user set name=:name, username=:username, password=:password where uuid=:uuid";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource param = new MapSqlParameterSource()

                .addValue("uuid", user.getId())

                .addValue("name", user.getName())

                .addValue("username", user.getUsername())

                .addValue("password", user.getPassword());

        template.update(sql,param, holder);
    }

    @Override
    public void executeUpdateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}

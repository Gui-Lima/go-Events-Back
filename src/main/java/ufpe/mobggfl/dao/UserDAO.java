package ufpe.mobggfl.dao;

import ufpe.mobggfl.models.Event;
import ufpe.mobggfl.models.Group;
import ufpe.mobggfl.models.User;
import java.util.List;
import java.util.UUID;

public interface UserDAO {
    List<User> findAll();

    User findUserById(UUID id);

    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

    void insertUser(User user);

    List<Group> getGroups(User user);

    List<Event> getEvents(User user);

    void joinGroup(User user, Group group);

    void updateUser(User user);

    void executeUpdateUser(User user);

    void deleteUser(User user);
}

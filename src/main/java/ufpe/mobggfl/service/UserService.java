package ufpe.mobggfl.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ufpe.mobggfl.dao.GroupDAO;
import ufpe.mobggfl.dao.UserDAO;
import ufpe.mobggfl.models.Event;
import ufpe.mobggfl.models.Group;
import ufpe.mobggfl.models.User;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDao;
    private final GroupDAO groupDAO;

    public UserService(@Qualifier("user")UserDAO userDAO,@Qualifier("group") GroupDAO groupDAO ){
        this.userDao = userDAO;
        this.groupDAO = groupDAO;
    }

    public void register(User user){
        this.userDao.insertUser(user);
    }

    public User login(String username, String password) {
         return this.userDao.findUserByUsernameAndPassword(username, password);
    }

    public List<Group> listAllGroupsByUsername(String username){
        User user = userDao.findUserByUsername(username);
        return this.userDao.getGroups(user);
    }

    public List<Event> listAllEventsByUsername(String username){
        User user = userDao.findUserByUsername(username);
        return this.userDao.getEvents(user);
    }

    public void joinGroup(String username, String groupname){
        User user = userDao.findUserByUsername(username);
        Group group = groupDAO.getGroupByName(groupname);
        userDao.joinGroup(user, group);
    }

    public List<User> listAllUsers(){
        return this.userDao.findAll();
    }
}

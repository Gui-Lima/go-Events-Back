package ufpe.mobggfl.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ufpe.mobggfl.dao.UserDAO;
import ufpe.mobggfl.models.User;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDao;

    public UserService(@Qualifier("postgress")UserDAO userDAO){
        this.userDao = userDAO;
    }

    public void register(User user){
        this.userDao.insertUser(user);
    }

    public boolean login(String username, String password) {
         if(this.userDao.findUserByUsernameAndPassword(username, password) == null){
             return false;
         }
         else return true;
    }

    public List<User> listAllUsers(){
        return this.userDao.findAll();
    }
}

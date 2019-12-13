package ufpe.mobggfl.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ufpe.mobggfl.dao.GroupDAO;
import ufpe.mobggfl.dao.UserDAO;
import ufpe.mobggfl.models.Group;
import java.util.List;

@Service
public class GroupService {

  private final GroupDAO groupDAO;
  private final UserDAO userDao;

  public GroupService(@Qualifier("group") GroupDAO groupDAO, @Qualifier("user")UserDAO userDao) {
    this.groupDAO = groupDAO;
    this.userDao = userDao;
  }

  public void addGroup(Group group){
    this.groupDAO.insertGroup(group);
    this.userDao.joinGroup(this.userDao.findUserById(group.getOwnerId()), group);
  }

  public List<Group> listAllGroups(){
    return this.groupDAO.getGroups();
  }

}

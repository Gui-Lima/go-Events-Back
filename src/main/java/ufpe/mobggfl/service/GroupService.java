package ufpe.mobggfl.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ufpe.mobggfl.dao.EventDAO;
import ufpe.mobggfl.dao.GroupDAO;
import ufpe.mobggfl.dao.UserDAO;
import ufpe.mobggfl.models.Event;
import ufpe.mobggfl.models.Group;
import java.util.List;

@Service
public class GroupService {

  private final GroupDAO groupDAO;
  private final UserDAO userDao;
  private final EventDAO eventDAO;

  public GroupService(@Qualifier("group") GroupDAO groupDAO, @Qualifier("user") UserDAO userDao, EventDAO eventDAO) {
    this.groupDAO = groupDAO;
    this.userDao = userDao;
    this.eventDAO = eventDAO;
  }

  public void addGroup(Group group){
    Group groupWithId = new Group(group.getName(), group.getOwnerId(),group.getOwnerName());
    this.groupDAO.insertGroup(groupWithId);
    this.userDao.joinGroup(this.userDao.findUserById(group.getOwnerId()), groupWithId);
  }

  public List<Group> listAllGroups(){
    return this.groupDAO.getGroups();
  }

  public void addEvent(Event event){
    this.eventDAO.insertEvent(event);
  }

}

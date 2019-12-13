package ufpe.mobggfl.dao;

import org.springframework.stereotype.Repository;
import ufpe.mobggfl.models.Event;
import ufpe.mobggfl.models.Group;
import ufpe.mobggfl.models.User;

import java.util.List;

public interface GroupDAO {

  void insertGroup(Group group);

  Group getGroupByName(String groupName);

  List<User> getUsers(Group group);

  List<Event> getEvents(Group group);

  List<Group> getGroups();
}

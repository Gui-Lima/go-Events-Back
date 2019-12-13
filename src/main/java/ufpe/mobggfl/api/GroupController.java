package ufpe.mobggfl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufpe.mobggfl.models.Group;
import ufpe.mobggfl.service.GroupService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/group")
@RestController
public class GroupController {

  private final GroupService groupService;

  @Autowired
  public GroupController(GroupService groupService) {
    this.groupService = groupService;
  }

  @PostMapping("register")
  public ResponseEntity addGroup(@RequestBody @Valid Group group){
    this.groupService.addGroup(group);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("all")
  public List<Group> listGroups(){
    return this.groupService.listAllGroups();
  }
}

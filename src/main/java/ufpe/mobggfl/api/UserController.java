package ufpe.mobggfl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpe.mobggfl.models.Event;
import ufpe.mobggfl.models.Group;
import ufpe.mobggfl.models.User;
import ufpe.mobggfl.service.UserService;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "all")
    public List<User> allUsers(){
        return this.userService.listAllUsers();
    }

    @GetMapping(path = "groups/{username}")
    public List<Group> allGroupsByUsername(@PathVariable String username){
        return this.userService.listAllGroupsByUsername(username);
    }

    @GetMapping(path = "events/{username}")
    public List<Event> allEventsByUsername(@PathVariable String username){
        return this.userService.listAllEventsByUsername(username);
    }

    @PostMapping(path= "groups/join/{username}/{groupName}")
    public ResponseEntity joinGroup(@PathVariable String username,@PathVariable String groupName){
        this.userService.joinGroup(username, groupName);
        return new ResponseEntity(HttpStatus.OK);
    }
}

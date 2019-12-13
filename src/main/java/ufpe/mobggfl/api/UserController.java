package ufpe.mobggfl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

}

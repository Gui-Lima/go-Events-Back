package ufpe.mobggfl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpe.mobggfl.exceptions.UserNotFoundException;
import ufpe.mobggfl.models.User;
import ufpe.mobggfl.service.UserService;

import javax.validation.Valid;

@RequestMapping("api/login")
@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "register")
    public ResponseEntity register(@RequestBody @Valid User user){
        this.userService.register(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "{username}/{encryptedPassword}")
    public User login(@PathVariable String username,@PathVariable String encryptedPassword){
        return this.userService.login(username, encryptedPassword);
    }

}

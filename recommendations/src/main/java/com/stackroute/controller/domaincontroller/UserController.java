package com.stackroute.controller.domaincontroller;


import com.stackroute.model.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping (value = "/api/v1/recommendation")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //To create user node
    @PostMapping(value = "/user")
        public ResponseEntity createUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        userService.createUser(user.getUserMail(),user.getRecommendation());
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    //To get user by userMail
    @GetMapping("/{userMail}")
    public User findByMail(@PathVariable String userMail) {
        return userService.findByEmail(userMail);
    }

    //To get all users
    @GetMapping("/allUsers")
    public Collection<User> getAllUser() {
        return userService.getAllUsers();
    }

    //To delete user by userMail
    @DeleteMapping("/user/{userMail}")
    public User delete(@PathVariable String userMail) {
        return userService.delete(userMail);
    }

    //To delete all users
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        userService.deleteAll();
        return "deletedAll";
    }
}

package com.stackroute.recommendations.controller.domaincontroller;


import com.stackroute.recommendations.domain.User;
import com.stackroute.recommendations.service.UserService;
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


    @PostMapping(value = "/user")
        public ResponseEntity createUser(@RequestBody User user) {
        ResponseEntity responseEntity;

        userService.createUser(user.getUserMail(),user.getPartition());
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public Collection<User> getAllUser() {
        return userService.getAllUsers();
    }

    //Delete user by userMail
    @DeleteMapping("/user/{userMail}")
    public User delete(@PathVariable String userMail) {
        return userService.delete(userMail);
    }


    //Delete all users
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        userService.deleteAll();
        return "deletedAll";
    }
}
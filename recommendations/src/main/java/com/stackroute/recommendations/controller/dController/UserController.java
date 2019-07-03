package com.stackroute.recommendations.controller.dController;


import com.stackroute.recommendations.domain.User;
import com.stackroute.recommendations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        responseEntity = new ResponseEntity(user, HttpStatus.CREATED);

        return responseEntity;

    }
}

package com.stackroute.LoginService.controller;

import com.stackroute.LoginService.exception.UserNotFoundException;
import com.stackroute.LoginService.jwt.SecurityTokenGenerator;
import com.stackroute.LoginService.model.User;
import com.stackroute.LoginService.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(value = "*")
@RequestMapping("/api")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> login(@RequestBody User loginDetails) throws Exception {


        String username = loginDetails.getName();
        String password = loginDetails.getPassword();

        if (username == null || password == null) {

            throw new Exception("password or username is null");
        }

        User user = userService.findByUserIdAndPassword(username, password);

        if (user == null) {
            throw new Exception("username is invalid");
        }

        String fetchedPassword = user.getPassword();

        if (!password.equals(fetchedPassword)) {
            throw new Exception("Incorrect password");
        }

        // generating token

        SecurityTokenGenerator securityTokenGenerator = (User userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId("" + user.getId()).setSubject(user.getName()).setAudience(user.getEmailId()).setIssuedAt(new Date())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();

            map1.put("token", jwtToken);

            map1.put("message", "User successfully logged in");

            return map1;

        };
        Map<String, String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    // @ApiOperation(value = "It saves all the user details")
    @PostMapping("/save/user")
    public ResponseEntity<?> saveEvent(@RequestBody User user) throws Exception {

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);

    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteTrack(@PathVariable("userId") int id) throws UserNotFoundException {
        ResponseEntity responseEntity;
        try {
            userService.deleteUser(id);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        } catch (UserNotFoundException exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


}

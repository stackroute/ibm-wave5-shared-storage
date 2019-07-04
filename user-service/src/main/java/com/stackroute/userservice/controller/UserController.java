package com.stackroute.userservice.controller;

import com.stackroute.userservice.jwt.SecurityTokenGenerator;
import com.stackroute.userservice.model.ActivityStream;
import com.stackroute.userservice.model.Producer;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(value = "*")
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    Producer producer;

    @Autowired
    ActivityStream activityStream;

    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    //user login by giving credentials , we  authenticate and generating the token
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody User loginDetails) throws Exception {


        String emailId = loginDetails.getEmailId();
        String password = loginDetails.getPassword();

        if (emailId == null || password == null) {

            throw new Exception("password or emailId is null");
        }

        User user = userService.findByEmailId(emailId);

        String fetchedEmailId = user.getEmailId();

        if (!emailId.equals(fetchedEmailId)) {
            throw new Exception("Incorrect emailId");

        }


        SecurityTokenGenerator securityTokenGenerator = (User userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId("" + user.getId()).setSubject(user.getFirstName()).setIssuer(user.getEmailId()).setAudience(user.getRole()).setIssuedAt(new Date())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();

            map1.put("token", jwtToken);

            map1.put("message", "User successfully logged in");

            return map1;
        };
        Map<String, String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);

    }

    // Getting all the users

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    // @ApiOperation(value = "It saves all the user details")
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User registrationDetails) throws Exception {

        String firstName = registrationDetails.getFirstName();
        String lastName = registrationDetails.getLastName();
        String mobileNo = registrationDetails.getMobileNo();
        String emailID = registrationDetails.getEmailId();

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String regex1="\\(?\\d+\\)?[-.\\s]?\\d+[-.\\s]?\\d+";

        if (!emailID.matches(regex) || emailID == null)
        {
            throw new Exception(("emailId invalid"));
        }

        if(!mobileNo.matches(regex1))
        {
            throw new Exception((" mobile number is invalid"));
        }

        if(firstName == "" || lastName == "")
        {
            throw new Exception(("Name not present"));
        }

        if( userRepository.existsByEmailId(registrationDetails.getEmailId())==false)
        {
            userService.saveUser(registrationDetails);
        }
        else
        {
            throw new Exception("EmailId already registered.");
        }

        System.out.println("Request Body displayed!"+ activityStream);
        activityStream.setRole(registrationDetails.getRole());
        activityStream.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        activityStream.setEmailId(registrationDetails.getEmailId());

        producer.send(activityStream);
        return new ResponseEntity<User>(registrationDetails, HttpStatus.OK);

    }

    //Deleting the user by their id
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int id) throws Exception {
        ResponseEntity responseEntity;
        try {
            userService.deleteUser(id);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        } catch ( Exception e) {

            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}

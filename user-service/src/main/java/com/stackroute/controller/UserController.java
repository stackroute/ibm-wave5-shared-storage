package com.stackroute.controller;

import com.stackroute.jwt.SecurityTokenGenerator;
import com.stackroute.model.UserProfile;
import com.stackroute.model.Producer;
import com.stackroute.model.Recommendations;
import com.stackroute.model.User;
import com.stackroute.service.UserService;
import com.stackroute.repository.UserRepository;
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
@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    Producer producer;

    @Autowired
    UserProfile userProfile;

    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Recommendations recommendations;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody User loginDetails) throws Exception {

        String name = loginDetails.getFirstName()+ " " + loginDetails.getLastName();
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

        // generating token

        SecurityTokenGenerator securityTokenGenerator = (User userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId(" " + user.getFirstName()).setSubject(" "+user.getMobileNo()).setIssuer(user.getEmailId()).setAudience(user.getRole()).setIssuedAt(new Date())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();

            map1.put("token", jwtToken);

            map1.put("message", "User successfully logged in");

            return map1;
        };
        Map<String, String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);

    }

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

        if (!emailID.matches(regex) || emailID == null)
        {
            throw new Exception(("emailId invalid"));
        }

        if(firstName == "" || lastName == "")
        {
            throw new Exception(("Name not present"));
        }

        if(mobileNo.length() >10 || mobileNo.length() <10)
        {
            throw new Exception(("Mobile No. is invalid"));
        }

        if( userRepository.existsByEmailId(registrationDetails.getEmailId())==false)
        {
            userService.saveUser(registrationDetails);
        }
        else
        {
            throw new Exception("EmailId already registered.");
        }

        System.out.println("Request Body displayed!"+ userProfile);
        userProfile.setRole(registrationDetails.getRole());
        userProfile.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        userProfile.setEmailId(registrationDetails.getEmailId());

        producer.send(userProfile);



        String name = firstName + " " + lastName;
       recommendations.setName(name);
       recommendations.setEmailId(registrationDetails.getEmailId());
       recommendations.setMobileNo(registrationDetails.getMobileNo());
       recommendations.setRole(registrationDetails.getRole());

        System.out.println("Request Body displayed!"+ recommendations);
        producer.send1(recommendations);
        return new ResponseEntity<User>(registrationDetails, HttpStatus.OK);

    }

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

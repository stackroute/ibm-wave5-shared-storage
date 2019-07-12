package com.stackroute.controller;

import com.stackroute.model.UserProfile;
import com.stackroute.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin("*")
public class UserProfileController {


    UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> addUserProfile(@RequestBody UserProfile userProfile) {
        ResponseEntity responseEntity;
        userProfileService.saveUserProfile(userProfile);
        responseEntity = new ResponseEntity<UserProfile>(userProfile, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/getbookings/{emailId}")
    public ResponseEntity<?> getOneMailHistory(@PathVariable("emailId") String userMailId) throws Exception {
        return new ResponseEntity<UserProfile>(this.userProfileService.getUserProfileByEmailId(userMailId), HttpStatus.OK);
    }
}

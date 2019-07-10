package com.stackroute.controller;

import com.stackroute.model.ActivityStream;
import com.stackroute.model.BookedStorageUnit;
import com.stackroute.services.ActivityStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin("*")
public class ActivityStreamController {


    ActivityStreamService activityStreamService;

    @Autowired
    public ActivityStreamController(ActivityStreamService activityStreamService) {
        this.activityStreamService = activityStreamService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> addActivityStream(@RequestBody ActivityStream activityStream) {
        ResponseEntity responseEntity;
        activityStreamService.saveActivityStream(activityStream);
        responseEntity = new ResponseEntity<ActivityStream>(activityStream, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/getbookings/{emailId}")
    public ResponseEntity<?> getOneMailHistory(@PathVariable("emailId") String userMailId) throws Exception {
        return new ResponseEntity<ActivityStream>(this.activityStreamService.getActivityStreamByEmailId(userMailId), HttpStatus.OK);
    }
}

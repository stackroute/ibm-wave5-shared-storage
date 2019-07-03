package com.stackroute.controller;


import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.model.ActivityStream;
import com.stackroute.model.ListedStorageUnit;
import com.stackroute.services.ActivityStreamService;
import com.stackroute.services.ListedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
@CrossOrigin ("*")
public class ActivityStreamController {


    ActivityStreamService activityStreamService;

    @Autowired
    public ActivityStreamController( ActivityStreamService activityStreamService) {
      this.activityStreamService = activityStreamService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> addActivityStream(@RequestBody ActivityStream activityStream) {
        ResponseEntity responseEntity;
            activityStreamService.saveActivityStream(activityStream);
            responseEntity = new ResponseEntity<ActivityStream>(activityStream, HttpStatus.CREATED);
            return responseEntity;

    }
}

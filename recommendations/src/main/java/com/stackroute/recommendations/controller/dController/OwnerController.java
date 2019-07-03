package com.stackroute.recommendations.controller.dController;

import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.domain.User;
import com.stackroute.recommendations.service.OwnerService;
import com.stackroute.recommendations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class OwnerController {

    OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }





    @PostMapping(value = "/owner")
    public ResponseEntity createUser(@RequestBody Owner owner) {

        ResponseEntity responseEntity;

        ownerService.createOwner(owner.getOwnerMail(),owner.getStorageUnit());
        responseEntity = new ResponseEntity(owner, HttpStatus.CREATED);

        return responseEntity;

    }
}

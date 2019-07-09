package com.stackroute.controller.domaincontroller;

import com.stackroute.model.Owner;
import com.stackroute.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class OwnerController {

    OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //To create Owner node
    @PostMapping(value = "/owner")
    public ResponseEntity createUser(@RequestBody Owner owner) {

        ResponseEntity responseEntity;

        ownerService.createOwner(owner.getOwnerMail(),owner.getStorageUnit());
        return new ResponseEntity(owner, HttpStatus.CREATED);
    }

    //To get all Owners
    @GetMapping("/allOwners")
    public Collection<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }
}

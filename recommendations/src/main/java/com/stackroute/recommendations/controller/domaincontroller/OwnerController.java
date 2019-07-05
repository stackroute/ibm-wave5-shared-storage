package com.stackroute.recommendations.controller.domaincontroller;

import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.service.OwnerService;
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

    @PostMapping(value = "/owner")
    public ResponseEntity createUser(@RequestBody Owner owner) {

        ResponseEntity responseEntity;

        ownerService.createOwner(owner.getOwnerMail(),owner.getStorageUnit());
        return new ResponseEntity(owner, HttpStatus.CREATED);
    }

    @GetMapping("/allOwners")
    public Collection<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }
}
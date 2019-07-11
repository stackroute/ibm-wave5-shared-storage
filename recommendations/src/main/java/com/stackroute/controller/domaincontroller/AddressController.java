package com.stackroute.controller.domaincontroller;

import com.stackroute.model.Addresses;
import com.stackroute.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class AddressController {

    AddressesService addressesService;

    @Autowired
    public AddressController(AddressesService addressesService) {
        this.addressesService = addressesService;
    }




    @PostMapping(value = "/addresses")
    public ResponseEntity createUser(@RequestBody Addresses addresses) {

        ResponseEntity responseEntity;

        addressesService.createAddresses(addresses.getArea(), addresses.getCity(), addresses.getState(), addresses.getCountry());
        return new ResponseEntity(addresses, HttpStatus.CREATED);



    }
}

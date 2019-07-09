package com.stackroute.controller.domaincontroller;

import com.stackroute.model.Address;
import com.stackroute.service.AddressService;
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

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }




    @PostMapping(value = "/address")
    public ResponseEntity createUser(@RequestBody Address address) {

        ResponseEntity responseEntity;

        addressService.createAddress(address.getArea(),address.getCity(),address.getState(),address.getCountry());
        return new ResponseEntity(address, HttpStatus.CREATED);



    }
}

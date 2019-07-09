package com.stackroute.controller.domaincontroller;

import com.stackroute.model.City;
import com.stackroute.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    //To create City node
    @PostMapping(value = "/city")
    public ResponseEntity createCity(@RequestBody City city) {

        ResponseEntity responseEntity;
        cityService.createCity(city.getCity());
        return new ResponseEntity(city, HttpStatus.CREATED);
    }

    //To get all City
    @GetMapping("/allCity")
    public Collection<City> getAllCity() {
        return cityService.getAllCity();
    }
}

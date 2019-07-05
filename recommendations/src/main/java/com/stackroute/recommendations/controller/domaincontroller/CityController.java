package com.stackroute.recommendations.controller.domaincontroller;

import com.stackroute.recommendations.domain.City;
import com.stackroute.recommendations.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value = "/city")
    public ResponseEntity createCity(@RequestBody City city) {

        ResponseEntity responseEntity;
        cityService.createCity(city.getCity());
        responseEntity = new ResponseEntity(city, HttpStatus.CREATED);
        return responseEntity;

    }
}

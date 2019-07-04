package com.stackroute.recommendations.controller.domaincontroller;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class AreaController
{
    AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping(value = "/area")
    public ResponseEntity createArea(@RequestBody Area area) {

        ResponseEntity responseEntity;
        areaService.createArea(area.getArea()) ;
        responseEntity = new ResponseEntity(area, HttpStatus.CREATED);
        return responseEntity;

    }

}

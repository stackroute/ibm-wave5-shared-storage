package com.stackroute.recommendations.controller.domaincontroller;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.City;
import com.stackroute.recommendations.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
        return new ResponseEntity(area, HttpStatus.CREATED);
    }

    @GetMapping("/allArea")
    public Collection<Area> getAllArea() {
        return areaService.getAllArea();
    }

}

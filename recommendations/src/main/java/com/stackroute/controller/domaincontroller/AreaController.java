package com.stackroute.controller.domaincontroller;

import com.stackroute.model.Area;
import com.stackroute.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class AreaController
{
    AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    //To create Area node
    @PostMapping(value = "/area")
    public ResponseEntity createArea(@RequestBody Area area) {

        ResponseEntity responseEntity;
        areaService.createArea(area.getArea()) ;
        return new ResponseEntity(area, HttpStatus.CREATED);
    }

    //To get all Area
    @GetMapping("/allArea")
    public Collection<Area> getAllArea() {
        return areaService.getAllArea();
    }

    @GetMapping("Location/{area}")
    public List<Area> getRecommendedLocation(@PathVariable String area){
        return areaService.getRecommendedLocation(area);
    }

}

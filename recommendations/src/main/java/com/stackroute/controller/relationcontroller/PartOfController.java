package com.stackroute.controller.relationcontroller;

import com.stackroute.model.Area;
import com.stackroute.model.StorageUnit;
import com.stackroute.service.PartOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/recommendation")
public class PartOfController
{
    PartOfService partOfService;

    @Autowired
    public PartOfController(PartOfService partOfService) {
        this.partOfService = partOfService;
    }

    //To create relationship between Area & City
    @PostMapping("/partof/{area}/{city}")
    public Area areaRelationship(@PathVariable String area, @PathVariable String city) {
        return  partOfService.createAreaRelationship(area,city);
    }

    //To get recommendation City
    @GetMapping("/partof/{city}")
    public Collection<StorageUnit> recommendationCity(@PathVariable String city) {
        return partOfService.getStorageUnitWithCity(city);
    }
}

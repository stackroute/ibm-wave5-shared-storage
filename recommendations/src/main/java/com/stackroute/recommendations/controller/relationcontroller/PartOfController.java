package com.stackroute.recommendations.controller.relationcontroller;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.service.PartOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}

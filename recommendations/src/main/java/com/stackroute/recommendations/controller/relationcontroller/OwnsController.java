package com.stackroute.recommendations.controller.relationcontroller;


import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.service.OwnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class OwnsController
{
    OwnsService ownsService;

    @Autowired
    public OwnsController(OwnsService ownsService) {
        this.ownsService = ownsService;
    }

    @PostMapping("/owns/{ownerMail}/{warehouseId}")
    public Owner userRelationship(@PathVariable String ownerMail, @PathVariable long warehouseId) {
        return ownsService.createUserRelationship(ownerMail,warehouseId);
    }
}





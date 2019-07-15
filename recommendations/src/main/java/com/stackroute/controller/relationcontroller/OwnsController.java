package com.stackroute.controller.relationcontroller;


import com.stackroute.model.Owner;
import com.stackroute.service.OwnsService;
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

    //To create relationship between Owner & StorageUnit
    @PostMapping("/owns/{ownerMail}/{warehouseId}")
    public Owner ownerRelationship(@PathVariable String ownerMail, @PathVariable long warehouseId) {
        return ownsService.createOwnerRelationship(ownerMail,warehouseId);
    }
}





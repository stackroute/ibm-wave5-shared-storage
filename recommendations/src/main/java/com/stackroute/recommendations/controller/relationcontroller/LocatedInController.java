package com.stackroute.recommendations.controller.relationcontroller;

import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.service.LocatedInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class LocatedInController
{
    LocatedInService locatedInService;

    @Autowired
    public LocatedInController(LocatedInService locatedInService) {
        this.locatedInService = locatedInService;
    }

    @PostMapping("/locatedIn/{warehouseId}/{area}")
    public StorageUnit storageUnitRelationship(@PathVariable long warehouseId, @PathVariable String area) {
        return  locatedInService.createAreaRelationship(warehouseId,area);

    }
}

package com.stackroute.controller.relationcontroller;

import com.stackroute.model.StorageUnit;
import com.stackroute.service.HasAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/recommendation")
public class HasAController {
    HasAService hasAService;

    @Autowired
    public HasAController(HasAService hasAService) {
        this.hasAService = hasAService;
    }

    //To get relationship
    @GetMapping("/StorageUnit/relationship")
    public Collection<StorageUnit> getRelationship() {
        return hasAService.getRelationship();
    }

    //To create relationship between StorageUnit & partition
    @PostMapping("/hasa/{warehouseId}/{pid}")
    public StorageUnit storageUnitRelationship(@PathVariable long warehouseId, @PathVariable long pid) {
        return hasAService.createStorageUnitRelationship(warehouseId, pid);

    }

    //Recommendation based on sqft
    @GetMapping("/SqftRecommendation")
    public Collection<StorageUnit> recommendationSqft() throws Exception {
        return hasAService.recommendationSqft() ;

    }

}

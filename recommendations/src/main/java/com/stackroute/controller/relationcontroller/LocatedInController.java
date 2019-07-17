package com.stackroute.controller.relationcontroller;

import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import com.stackroute.service.LocatedInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class LocatedInController
{
    LocatedInService locatedInService;

    @Autowired
    public LocatedInController(LocatedInService locatedInService) {
        this.locatedInService = locatedInService;
    }

    //To create relationship between StorageUnit & Area
    @PostMapping("/locatedIn/{warehouseId}/{area}")
    public StorageUnit storageUnitRelationship(@PathVariable long warehouseId, @PathVariable String area) {
        return  locatedInService.createAreaRelationship(warehouseId,area);

    }



    //To create relationship between Partition & Area
    @PostMapping("/newRelationship/partition/{pid}/{area}")
    public Partition relationshipArea(@PathVariable Long pid, @PathVariable String area) {
        Partition partition1 = locatedInService.createRelationshipArea(pid,area);
        return partition1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship/partition")
    public Partition relationshipdeleteCategory() {
        Partition partition1 = locatedInService.deleteRelationshipArea();
        return partition1;
    }



    //To get recommendation Location
    @GetMapping("recommendationLocation")
    public Collection<StorageUnit> recommendationLocation() throws Exception {
        return locatedInService.createRecommendationLocation();
    }


}

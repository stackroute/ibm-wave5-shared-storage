package com.stackroute.recommendations.controller.domaincontroller;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.service.PartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class PartitionController {

    PartitionService partitionService;

    @Autowired
    public PartitionController(PartitionService partitionService) {
        this.partitionService = partitionService;
    }

    @PostMapping(value = "/partition")
    public ResponseEntity createPartition(@RequestBody Partition partition) {

        ResponseEntity responseEntity;

        partitionService.createPartition(partition.getPid(),partition.getArea(),partition.getCost());
        return new ResponseEntity(partition, HttpStatus.CREATED);
    }

    @GetMapping("/allPartitions")
    public Collection<Partition> getAllUser() {
        return partitionService.getAllPartitions();
    }
}
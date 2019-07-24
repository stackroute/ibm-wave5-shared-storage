package com.stackroute.controller.domaincontroller;

import com.stackroute.model.Partition;
import com.stackroute.service.PartitionService;
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

    //To create Partition node
    @PostMapping(value = "/partition")
    public ResponseEntity createPartition(@RequestBody Partition partition) {

        ResponseEntity responseEntity;

        partitionService.createPartition(partition.getPid(),partition.getSqft(),partition.getCost(),partition.getCityName());
        return new ResponseEntity(partition, HttpStatus.CREATED);
    }

    //To get partition by id
    @GetMapping("/partition/{pid}")
    public Partition getByPid(@PathVariable long pid) {
        return partitionService.findByPid(pid);
    }

    //To get all Partitions
    @GetMapping("/allPartitions")
    public Collection<Partition> getAllPartition() {
        return partitionService.getAllPartitions();
    }

    //To delete partition by id
    @DeleteMapping("/{pid}")
    public Partition delete(@PathVariable Long pid) {
        return partitionService.delete(pid);
    }

    //To update user by pid
    @PutMapping("/{pid}")
    public Partition update(@PathVariable long pid, @RequestBody Partition partition) {
        return partitionService.update(pid, partition.getSqft(), partition.getCost());
    }
}

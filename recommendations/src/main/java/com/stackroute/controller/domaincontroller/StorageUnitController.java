package com.stackroute.controller.domaincontroller;

import com.stackroute.model.StorageUnit;
import com.stackroute.service.StorageUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/recommendation")
public class StorageUnitController {

  StorageUnitService storageUnitService;

  @Autowired
    public StorageUnitController(StorageUnitService storageUnitService) {
        this.storageUnitService = storageUnitService;
    }

    //Create Storage Unit node
    @PostMapping(value = "/storage")
    public ResponseEntity createStorage(@RequestBody StorageUnit storageUnit) {
        ResponseEntity responseEntity;
        storageUnitService.createStorage(storageUnit.getWarehouseId(),storageUnit.getWarehouseName(),storageUnit.getOwnerMail(),storageUnit.getAddresses(),storageUnit.getPartitions());
        return new ResponseEntity(storageUnit, HttpStatus.CREATED);
    }

    @GetMapping("/find/{warehouseName}")
    public StorageUnit findByName(@PathVariable String warehouseName) {
        return storageUnitService.findByName(warehouseName);
    }

    //To Get all Storage Unit
    @GetMapping("/allStorageUnit")
    public Collection<StorageUnit> getAllUser() {
        return storageUnitService.getAllStorageUnit();
    }

    //To get all Partition
    @GetMapping("/allPartition")
    public Collection<String> getAllPartition() {
        return storageUnitService.getAllPartition();
    }

    //Delete user by warehouseId
    @DeleteMapping("/user/{warehouseId}")
    public StorageUnit delete(@PathVariable long warehouseId) {
        return storageUnitService.delete(warehouseId);
    }


    //Delete all storage
    @DeleteMapping("/deleteAllStorageUnit")
    public String deleteAll() {
        storageUnitService.deleteAll();
        return "deletedAll";
    }


}


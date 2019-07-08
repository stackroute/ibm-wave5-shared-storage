package com.stackroute.recommendations.controller.domaincontroller;

import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.service.StorageUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
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
        storageUnitService.createStorage(storageUnit.getWarehouseId(),storageUnit.getWarehouseName(),storageUnit.getOwnerMail(),storageUnit.getAddress(),storageUnit.getPartitions());
        return new ResponseEntity(storageUnit, HttpStatus.CREATED);
    }

    //To Get all Storage Unit
    @GetMapping("/allStorageUnit")
    public Collection<StorageUnit> getAllUser() {
        return storageUnitService.getAllStorageUnit();
    }

//    //Delete user by warehouseId
//    @DeleteMapping("/user/{warehouseId}")
//    public StorageUnit delete(@PathVariable Long warehouseId) {
//        return storageUnitService.delete(warehouseId);
//    }
//
//
//    //Delete all storage
//    @DeleteMapping("/deleteAll")
//    public String deleteAll() {
//        storageUnitService.deleteAll();
//        return "deletedAll";
//    }
}


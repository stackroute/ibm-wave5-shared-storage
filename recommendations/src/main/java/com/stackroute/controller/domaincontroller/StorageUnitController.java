package com.stackroute.controller.domaincontroller;

import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import com.stackroute.service.StorageUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/recommendation", produces = MediaType.APPLICATION_JSON_VALUE)
public class StorageUnitController {

  StorageUnitService storageUnitService;

  @Autowired
    public StorageUnitController(StorageUnitService storageUnitService) {
        this.storageUnitService = storageUnitService;
    }

    // To create new Storage Unit
    @PostMapping("/storage")
    public StorageUnit createStorage(@RequestBody StorageUnit storageUnit, Partition partition, String imageUrl) {
        StorageUnit storageUnit1 =storageUnitService.createStorage(storageUnit.getWarehouseId(),storageUnit.getWarehouseName(),storageUnit.getOwnerMail(), storageUnit.getImageUrl());
        return storageUnit1;
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

//    @GetMapping("/Location/{city}")
//    public Collection<StorageUnit> getStorageUnitCity(@PathVariable String city) {
//        return storageUnitService.getStorageUnitCity(city);
//    }

    @GetMapping("/locations/{sqft}")
    public Collection<StorageUnit> getStorageUnitSQFT(@PathVariable long sqft) {
        return storageUnitService.getStorageUnitSqft(sqft);
    }

    @GetMapping("/location/{area}/{sqft}")
    public Collection<StorageUnit> getStorageUnitLocationSqft(@PathVariable String area,@PathVariable Long sqft) {
        Collection<StorageUnit> storageUnits;
         storageUnits=storageUnitService.getStorageUnitLocationsqft(area, sqft);
        return storageUnits;
    }


}


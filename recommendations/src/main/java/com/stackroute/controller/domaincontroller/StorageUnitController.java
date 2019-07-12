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
@CrossOrigin("*")
public class StorageUnitController {

  StorageUnitService storageUnitService;

  @Autowired
    public StorageUnitController(StorageUnitService storageUnitService) {
        this.storageUnitService = storageUnitService;
    }

    // To create new Storage Unit
    @PostMapping("/storage")
    public StorageUnit createStorage(@RequestBody StorageUnit storageUnit) {
        StorageUnit storageUnit1 =storageUnitService.createStorage(storageUnit.getWarehouseId(),storageUnit.getWarehouseName(),storageUnit.getOwnerMail());
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

    @GetMapping("/location/{area}")
    public Collection<StorageUnit> getStorageUnit(@PathVariable String area) {
        return storageUnitService.getStorageUnit(area);
    }

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


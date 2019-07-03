package com.stackroute.recommendations.controller.dController;

import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.service.StorageUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/recommendation")
public class StorageUnitController {

  StorageUnitService storageUnitService;

  @Autowired
    public StorageUnitController(StorageUnitService storageUnitService) {
        this.storageUnitService = storageUnitService;
    }

    @PostMapping(value = "/storage")
    public ResponseEntity createStorage(@RequestBody StorageUnit storageUnit) {

        ResponseEntity responseEntity;

        storageUnitService.createStorage(storageUnit.getWarehouseId(),storageUnit.getWarehouseName(),storageUnit.getOwnerMail(),storageUnit.getAddress(),storageUnit.getPartitions());
        responseEntity = new ResponseEntity(storageUnit, HttpStatus.CREATED);

        return responseEntity;

    }
}


package com.stackroute.controller;

import com.stackroute.exceptions.PartitionAlreadyExists;
import com.stackroute.exceptions.WarehouseAlreadyExistsException;
import com.stackroute.exceptions.WarehouseNotfound;
import com.stackroute.model.Partition;
import com.stackroute.model.Warehouse;
import com.stackroute.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {
    WarehouseService warehouseService;


    @Autowired
    public UserController(WarehouseService warehouseService) {

        this.warehouseService = warehouseService;
    }


    @PatchMapping("/warehousepart/{id}")
    public ResponseEntity<?> addPartition(@Valid @RequestBody Partition partition, @PathVariable("id") int id, Warehouse warehouse) throws WarehouseAlreadyExistsException, WarehouseNotfound {
        ResponseEntity responseEntity;


        try {
            Warehouse warehouse1 = warehouseService.getOneWarehouse(id);
            warehouse1.getPartitions().add(partition);
            warehouseService.saveWarehousePart(warehouse1);
            responseEntity = new ResponseEntity<String>("Successfully created the partition", HttpStatus.CREATED);

        } catch (WarehouseNotfound ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        } catch (PartitionAlreadyExists ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @PostMapping("/warehouse")
    public ResponseEntity<?> addWareHouse(@Valid @RequestBody Warehouse wareHouse) throws WarehouseAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
//            int id=wareHouse.getId()+1;
//            wareHouse.setId(id);
            warehouseService.saveWarehouse(wareHouse);
            responseEntity = new ResponseEntity<String>("Successfully created warehouse", HttpStatus.CREATED);

        } catch (WarehouseAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    @GetMapping("/warehouses")
    public ResponseEntity<?> getAllWarehouses() {
        return new ResponseEntity<List<Warehouse>>(warehouseService.getAllWarehouses(), HttpStatus.OK);
    }

    @PatchMapping("/warehouse")
    public ResponseEntity<?> updateAlbum(@RequestBody Warehouse wareHouse) throws WarehouseNotfound {
        ResponseEntity responseEntity;
        try {
            warehouseService.updateWarehouse(wareHouse);
            responseEntity = new ResponseEntity<String>("Updated warehouse Successfully", HttpStatus.CREATED);
        } catch (WarehouseNotfound exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/warehouseno/{id}")
    public ResponseEntity<?> removeWarehouse(@PathVariable("id") int id) throws WarehouseNotfound {
        ResponseEntity responseEntity;
        try {
            warehouseService.deleteWarehouse(id);
            responseEntity = new ResponseEntity<String>("Deleted warehouse successfully", HttpStatus.OK);
        } catch (WarehouseNotfound exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/oneWarehouse/{id}")
    public ResponseEntity<?> retrieveWarehouse(@PathVariable("id") int id) throws WarehouseNotfound {

        return new ResponseEntity<Warehouse>(warehouseService.getOneWarehouse(id), HttpStatus.OK);
    }
}

package com.stackroute.controller;

import com.stackroute.exceptions.PartitionAlreadyExists;
import com.stackroute.exceptions.WarehouseAlreadyExistsException;
import com.stackroute.exceptions.WarehouseNotfound;
import com.stackroute.model.ListedStorageUnit;
import com.stackroute.model.Partition;
import com.stackroute.model.Producer;
import com.stackroute.model.Warehouse;
import com.stackroute.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin("*")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ListedStorageUnit listedStorageUnit;

    @Autowired
    Producer producer;


    @Autowired
    public WarehouseController(WarehouseService warehouseService) {

        this.warehouseService = warehouseService;
    }


    //posting the warehouse
    @PostMapping("/warehouse")
    public ResponseEntity<?> addWareHouse(@Valid @RequestBody Warehouse listedStorage) throws WarehouseAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
            warehouseService.saveWarehouse(listedStorage);
            responseEntity = new ResponseEntity<Warehouse>(listedStorage, HttpStatus.CREATED);

        } catch (WarehouseAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        System.out.println("Request Body displayed!"+ listedStorage);

        listedStorageUnit.setEmailId(listedStorage.getOwnerMail());
        listedStorageUnit.setName(listedStorage.getWarehouseName());
        listedStorageUnit.setId(listedStorage.getId());
        listedStorageUnit.setAddress(listedStorage.getAddress());

        producer.send(listedStorageUnit);
        System.out.println(listedStorageUnit.toString());
        return responseEntity;
    }

//    patching the  partition into particular warhouse
    @PatchMapping("/warehousepart/{id}")
    public ResponseEntity<?> addPartition(@Valid @RequestBody Partition partition, @PathVariable("id") int id, Warehouse warehouse) throws WarehouseAlreadyExistsException, WarehouseNotfound {
        ResponseEntity responseEntity;


        try {
            Warehouse warehouse1 = warehouseService.getOneWarehouse(id);
            warehouse1.getPartitions().add(partition);
            warehouseService.saveWarehousePart(warehouse1);
            responseEntity = new ResponseEntity<String>("Successfully created the partition", HttpStatus.OK);

        } catch (WarehouseNotfound ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
        } catch (PartitionAlreadyExists ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }


    //getMapping to see all the warehouses in the database
    @GetMapping("/warehouses")
    public ResponseEntity<?> getAllWarehouses() {
        return new ResponseEntity<List<Warehouse>>(warehouseService.getAllWarehouses(), HttpStatus.OK);
    }

    //to modify any feild in already exist wraehouse
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

    //deleting the warehouse by providing the warehouse id
    @DeleteMapping("/warehouseno/{id}")
    public ResponseEntity<?> removeWarehouse(@PathVariable("id") int id) throws WarehouseNotfound {
        ResponseEntity responseEntity;
        try {
            warehouseService.deleteWarehouse(id);
            responseEntity = new ResponseEntity<String>("Deleted warehouse successfully", HttpStatus.OK);
        } catch (WarehouseNotfound exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }

    //getting one warehouse bby giving the warehouse id
    @GetMapping("/oneWarehouse/{id}")
    public ResponseEntity<?> retrieveWarehouse(@PathVariable("id") int id) throws WarehouseNotfound {

        return new ResponseEntity<Warehouse>(warehouseService.getOneWarehouse(id), HttpStatus.OK);
    }
}

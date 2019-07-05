package com.stackroute.controller;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.services.BookedService;
import com.stackroute.exceptions.StorageUnitNotFound;
import com.stackroute.model.ActivityStream;
import com.stackroute.model.ListedStorageUnit;
import com.stackroute.services.ListedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
@CrossOrigin("*")
public class ListedStorageController
{

    ListedService listedService;

    BookedService bookedService;
  
    ActivityStream activityStream;

    @Autowired
    public ListedStorageController(ListedService listedService, BookedService bookedService, ActivityStream activityStream) {
        this.listedService = listedService;
        this.activityStream = activityStream;

        this.bookedService = bookedService;
    }

    @PostMapping("/savestorage")
       public ResponseEntity<?> addListedStorageUnit(@RequestBody ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException {
        ResponseEntity responseEntity;
        try {

            listedService.saveListedStorageUnit(listedStorageUnit);
            responseEntity= new ResponseEntity<ListedStorageUnit>(listedStorageUnit, HttpStatus.CREATED);

        } catch (StorageUnitAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
    @GetMapping("/getallpartition")
    public ResponseEntity<?> getAllListedStorageUnit(){
        return  new ResponseEntity<List<ListedStorageUnit>>(listedService.getAllListedStorageUnit(),HttpStatus.OK);
    }

    @PatchMapping("/patchStorage")
    public ResponseEntity<?> updateListedStorage(@RequestBody ListedStorageUnit listedStorageUnit) throws StorageUnitNotFound {
        ResponseEntity responseEntity;
        try{
            listedService.updateStorageUnit(listedStorageUnit);
            responseEntity=new ResponseEntity<String>("storagespace Updated Successfully", HttpStatus.CREATED);
        }
        catch(StorageUnitNotFound exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/storageNo/{id}")
    public ResponseEntity<?> deleteListedStorage(@PathVariable("id") Integer id) throws StorageUnitNotFound
    {
        ResponseEntity responseEntity;
        try {
            listedService.deleteListedStorageUnit(id);
            responseEntity = new ResponseEntity<String>("storagespace Deleted successfully", HttpStatus.OK);
        }
        catch(StorageUnitNotFound exception){

            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}

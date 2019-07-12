package com.stackroute.controller;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFoundException;
import com.stackroute.model.BookedStorageUnit;
import com.stackroute.services.UserProfileService;
import com.stackroute.services.BookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin("*")
public class BookedStorageController {
    BookedService bookedService;
    UserProfileService streamService;

    @Autowired
    public BookedStorageController(BookedService bookedService, UserProfileService streamService) {
        this.streamService = streamService;
        this.bookedService = bookedService;
    }


    @PostMapping("/savebookings")
    public ResponseEntity<?> addBookedStorageUnit(@RequestBody BookedStorageUnit bookedStorageUnit) throws StorageUnitAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
            bookedService.saveBookedStorageUnit(bookedStorageUnit);
            responseEntity = new ResponseEntity<BookedStorageUnit>(bookedStorageUnit, HttpStatus.CREATED);

        } catch (StorageUnitAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @GetMapping("/getallbookings")
    public ResponseEntity<?> getAllBookedStorageUnit() {
        return new ResponseEntity<List<BookedStorageUnit>>(bookedService.getAllBookedStorageUnit(), HttpStatus.OK);
    }





    @DeleteMapping("/bookingNo/{id}")
    public ResponseEntity<?> deleteBookedStorage(@PathVariable("id") Integer id) throws StorageUnitNotFoundException {
        ResponseEntity responseEntity;
        try {
            bookedService.deleteBookedStorageUnit(id);
            responseEntity = new ResponseEntity<String>("storagespace Deleted successfully", HttpStatus.OK);
        } catch (StorageUnitNotFoundException exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
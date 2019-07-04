package com.stackroute.controller;

import com.stackroute.model.BookedStorageUnit;
import com.stackroute.model.History;
import com.stackroute.model.Producer;
import com.stackroute.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;




@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin("*")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @Autowired
     private Producer producer;

    @Autowired
    private BookedStorageUnit bookedStorageUnit;


    @Autowired
    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }


    @PostMapping("/history")
    public ResponseEntity<?> addHistory(@Valid @RequestBody History history) throws Exception{
        ResponseEntity responseEntity;
        try {
            bookingService.saveHistory(history);
            responseEntity = new ResponseEntity<History>(history, HttpStatus.CREATED);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

        }
        System.out.println("Request Body displayed!!!"+ history);

        bookedStorageUnit.setEmailId(history.getUserMailId());
        bookedStorageUnit.setId(history.getWarehouseId());
        bookedStorageUnit.setName(history.getUserName());
        bookedStorageUnit.setLocation(history.getLocation());
        bookedStorageUnit.setSqft(history.getSqft());
        bookedStorageUnit.setStartDate(history.getStartDate());
        bookedStorageUnit.setEndDate(history.getEndDate());

        producer.send(bookedStorageUnit);
        System.out.println(bookedStorageUnit.toString());
        return responseEntity;
    }


    @GetMapping("/histories")
    public ResponseEntity<?> getAllHistory() throws Exception {
        return new ResponseEntity<List<History>>(bookingService.getAllHistory(),HttpStatus.OK);    }

    @DeleteMapping("/history/{id}")
    public ResponseEntity<?> removeHistory(@PathVariable("id") int id) throws Exception {
        ResponseEntity responseEntity;
        try {
            bookingService.deleteHistory(id);
            responseEntity = new ResponseEntity<String>("Deleted warehouse successfully", HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}

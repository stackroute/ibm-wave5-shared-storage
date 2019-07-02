package com.stackroute.controller;

import com.stackroute.domain.History;
import com.stackroute.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;




@RestController
@RequestMapping(value = "api/v1")
public class BookingController {
    BookingService bookingService;


    @Autowired
    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }


    @PostMapping("/history")
    public ResponseEntity<?> addHistory(@Valid @RequestBody History history) throws Exception{
        ResponseEntity responseEntity;
        try {
            bookingService.saveHistory(history);
            responseEntity = new ResponseEntity<String>("Successfully created warehouse", HttpStatus.CREATED);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

        }
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

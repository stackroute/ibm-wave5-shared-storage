package com.stackroute.controller;

import com.stackroute.model.*;
import com.stackroute.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/v1")
public class BookingController {

   @Autowired
    BookingService bookingService;

    @Autowired
    Producer producer;

    @Autowired
    BookedStorageUnit bookedStorageUnit;

   @Autowired
    Tenant tenant;

   @Autowired
    Recommendation recommendation;

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
        bookedStorageUnit.setId(history.getBookingIdentity().getWarehouseId());
        bookedStorageUnit.setName(history.getUserName());
        bookedStorageUnit.setLocation(history.getLocation());
        bookedStorageUnit.setSqft(history.getSqft());
        bookedStorageUnit.setStartDate(history.getStartDate());
        bookedStorageUnit.setEndDate(history.getEndDate());

        producer.send1(bookedStorageUnit);
        System.out.println(bookedStorageUnit.toString());

        tenant.setTenantName(history.getUserName());
        tenant.setTenantEmailId(history.getUserMailId());
        tenant.setTenantMobileNo(history.getUserMobile());
        tenant.setStartDate(history.getStartDate());
        tenant.setLastDate(history.getEndDate());

        producer.send(tenant);
        System.out.println(tenant.toString());

        recommendation.setPid(history.getBookingIdentity().getPid());
        recommendation.setUserMail(history.getUserMailId());
        recommendation.setUserMail(history.getUserMailId());
        recommendation.setSqft(history.getSqft());
        recommendation.setCost(history.getCost());
        recommendation.setLocation(history.getLocation());

        producer.send3(recommendation);
        System.out.println(recommendation.toString());

        return responseEntity;
    }

    @GetMapping("/histories/{userMailId}")
    public ResponseEntity<?> getOneMailHistory(@PathVariable("userMailId") String userMailId) throws Exception {
        return new ResponseEntity<List<History>>(bookingService.OneMailHistory(userMailId),HttpStatus.OK);    }

    @GetMapping("/histories")
    public ResponseEntity<?> getAllHistory() throws Exception {
        return new ResponseEntity<List<History>>(bookingService.getAllHistory(),HttpStatus.OK);    }

    @DeleteMapping("/history/{warehouseId}/{pid}")
    public ResponseEntity<?> removeHistory(@PathVariable("warehouseId") int warehouseId,@PathVariable("pid") int pid ) throws Exception {
        ResponseEntity responseEntity;
        try {
            bookingService.deleteHistory(new BookingIdentity(warehouseId,pid));
            responseEntity = new ResponseEntity<String>("Deleted warehouse successfully", HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}

package com.stackroute.recommendations.controller.relationcontroller;

import com.stackroute.recommendations.domain.User;
import com.stackroute.recommendations.service.BookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/recommendation")

public class BookedController {

    BookedService bookedService;

    @Autowired
    public BookedController(BookedService bookedService) {
        this.bookedService = bookedService;
    }

    //To create relationship between user & partition
    @PostMapping ("/bookd/{userMail}/{pid}")
    public User userRelationship(@PathVariable String userMail, @PathVariable long pid) {
      return bookedService.createUserRelationship(userMail,pid);
    }

    //To get relationship between user & partition
    @GetMapping("/relationship")
    public Collection<User> getRelationship() {
        return bookedService.getRelationship();
    }
}

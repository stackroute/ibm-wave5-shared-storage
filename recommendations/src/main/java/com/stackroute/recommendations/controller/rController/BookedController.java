package com.stackroute.recommendations.controller.rController;

import com.stackroute.recommendations.domain.User;
import com.stackroute.recommendations.service.BookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/recommendation")

public class BookedController {

    BookedService bookedService;

    @Autowired
    public BookedController(BookedService bookedService) {
        this.bookedService = bookedService;
    }


    @PostMapping ("/newRelation/{userMail}/{pid}")
    public User userRelationship(@PathVariable String userMail, @PathVariable long pid) {
        User myUser = bookedService.createUserRelationship(userMail,pid);

        return myUser;
    }
}

package com.stackroute.services;

import com.stackroute.model.ActivityStream;
import com.stackroute.repository.ActivityStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActivityStreamImpl implements ActivityStreamService {


    ActivityStreamRepository activityStreamRepository;


    @Autowired
    public ActivityStreamImpl(ActivityStreamRepository activityStreamRepository) {
        this.activityStreamRepository = activityStreamRepository;

    }

    @Override
    public ActivityStream saveActivityStream(ActivityStream activityStream1) {

        ActivityStream myActivity = activityStreamRepository.save(activityStream1);
        return myActivity;

    }
}
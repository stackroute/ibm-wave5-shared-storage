package com.stackroute.services;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFoundException;
import com.stackroute.model.ActivityStream;
import com.stackroute.model.BookedStorageUnit;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ActivityStreamService
{
    public ActivityStream saveActivityStream(ActivityStream activityStream1);
}

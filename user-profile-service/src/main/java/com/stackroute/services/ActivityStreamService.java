package com.stackroute.services;

import com.stackroute.model.ActivityStream;

public interface ActivityStreamService
{
    public ActivityStream saveActivityStream(ActivityStream activityStream1);
    public ActivityStream getActivityStreamByEmailId(String id);
}

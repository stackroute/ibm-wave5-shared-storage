package com.stackroute.services;

import com.stackroute.model.UserProfile;

public interface UserProfileService
{
    public UserProfile saveUserProfile(UserProfile userProfile1);
    public UserProfile getUserProfileByEmailId(String id);
}

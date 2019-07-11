package com.stackroute.services;

import com.stackroute.model.UserProfile;
import com.stackroute.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileServiceImpl implements UserProfileService {


    UserProfileRepository userProfileRepository;


    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;

    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile1) {

        UserProfile myActivity = userProfileRepository.save(userProfile1);
        return myActivity;

    }

    public UserProfile getUserProfileByEmailId(String id) {
        UserProfile myActivity = userProfileRepository.findByemailId(id);
        return  myActivity;
    }
}
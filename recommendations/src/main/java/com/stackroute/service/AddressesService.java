package com.stackroute.service;

import com.stackroute.model.Addresses;

public interface AddressesService {
    public Addresses createAddresses(String area, String city, String state, String country);
}
package com.stackroute.service;

import com.stackroute.model.Addresses;

public interface AddressService {
    public Addresses createAddress(String area, String city, String state, String country);
}
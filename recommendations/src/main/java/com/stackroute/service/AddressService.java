package com.stackroute.service;

import com.stackroute.model.Address;

public interface AddressService {
    public Address createAddress(String area, String city, String state, String country);
}
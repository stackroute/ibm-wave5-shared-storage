package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Address;

public interface AddressService {
    public Address createAddress(String area, String city, String state, String country);
}
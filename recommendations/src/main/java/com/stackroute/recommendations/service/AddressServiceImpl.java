package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Address;
import com.stackroute.recommendations.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;


    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(String area, String city, String state, String country) {
        return addressRepository.saveAddress(area,city,state,country);
    }
}

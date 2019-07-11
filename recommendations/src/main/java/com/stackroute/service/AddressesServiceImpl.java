package com.stackroute.service;

import com.stackroute.model.Addresses;
import com.stackroute.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressesServiceImpl implements AddressesService {

    AddressRepository addressRepository;


    @Autowired
    public AddressesServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Addresses createAddresses(String area, String city, String state, String country) {
        return addressRepository.saveAddresses(area,city,state,country);
    }
}

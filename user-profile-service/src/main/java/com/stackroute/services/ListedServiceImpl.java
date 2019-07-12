package com.stackroute.services;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFound;
import com.stackroute.model.UserProfile;
import com.stackroute.model.ListedStorageUnit;
import com.stackroute.repository.ListedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListedServiceImpl implements ListedService {
    ListedRepository listedRepository;

    ListedStorageUnit listedStorageUnit;

    @Autowired
    UserProfile userProfile;

    @Autowired
    public ListedServiceImpl(ListedRepository listedRepository) {
        this.listedRepository = listedRepository;
    }

    @Override
    public List<ListedStorageUnit> getAllListedStorageUnit() {
        return listedRepository.findAll();
    }

    @Override
    public ListedStorageUnit saveListedStorageUnit(ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException {

        if (listedRepository.existsById(listedStorageUnit.getId())) {
            throw new StorageUnitAlreadyExistsException("warehouse already exists with id:[" + listedStorageUnit.getId() + "]");
        }
        listedRepository.save(listedStorageUnit);
        return listedStorageUnit;
    }

    @Override
    public boolean deleteListedStorageUnit(int id) throws StorageUnitNotFound {
        boolean status = false;
        if (listedRepository.existsById(id)) {
            listedRepository.deleteById(id);
            status = true;
            return status;
        } else {
            throw new StorageUnitNotFound("warehouseId not exists");
        }
    }

    @Override
    public List<ListedStorageUnit> OneMailUserHistory(String userMailId) {

        List<ListedStorageUnit> listedStorageUnits = listedRepository.findAll();
        List<ListedStorageUnit> finalSelected = new ArrayList<>();
        for (ListedStorageUnit listed : listedStorageUnits) {
            if (listed.getEmailId().equals(userMailId)) {
                finalSelected.add(listed);
            }
        }
        return finalSelected;
    }

    @Override
    public ListedStorageUnit updateStorageUnit(ListedStorageUnit listedStorageUnit) throws StorageUnitNotFound {
        if (listedRepository.existsById(listedStorageUnit.getId())) {
            ListedStorageUnit savedListedStorageUnit = listedRepository.save(listedStorageUnit);
            return savedListedStorageUnit;
        } else {
            throw new StorageUnitNotFound("wareHouse not found");
        }

    }

}


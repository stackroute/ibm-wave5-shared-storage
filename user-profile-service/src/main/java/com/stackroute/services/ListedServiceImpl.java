package com.stackroute.services;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFound;
import com.stackroute.model.ActivityStream;
import com.stackroute.model.ListedStorageUnit;
//import com.stackroute.model.Partition;
import com.stackroute.repository.ListedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListedServiceImpl implements ListedService
{
  ListedRepository listedRepository;

  ListedStorageUnit listedStorageUnit;

  @Autowired
  ActivityStream activityStream;

  @Autowired
  public ListedServiceImpl(ListedRepository listedRepository)
  {
    this.listedRepository = listedRepository;
  }

  @Override
  public List<ListedStorageUnit> getAllListedStorageUnit() {
    return  listedRepository.findAll();
  }

  @Override
  public ListedStorageUnit saveListedStorageUnit(ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException {

    if(listedRepository.existsById(listedStorageUnit.getId())) {
  throw new StorageUnitAlreadyExistsException("warehouse already exists with id:[" + listedStorageUnit.getId() + "]");
  }
    listedRepository.save(listedStorageUnit);
    return listedStorageUnit;
  }

  @Override
  public boolean deleteListedStorageUnit(int id) throws StorageUnitNotFound {
    boolean status = false;
    if(listedRepository.existsById(id)){
      listedRepository.deleteById(id);
      status=true;
      return status;
    }
    else
      {
      throw new StorageUnitNotFound("warehouseId not exists");
    }
  }

  @Override
  public ListedStorageUnit updateStorageUnit(ListedStorageUnit listedStorageUnit) throws StorageUnitNotFound {
    if(listedRepository.existsById(listedStorageUnit.getId()))
    {
      ListedStorageUnit savedListedStorageUnit = listedRepository.save(listedStorageUnit);
      return savedListedStorageUnit;
    }
    else{
      throw new StorageUnitNotFound("wareHouse not found");
    }

  }
}
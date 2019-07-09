package com.stackroute.services;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFoundException;
import com.stackroute.model.BookedStorageUnit;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookedService {

    public List<BookedStorageUnit> getAllBookedStorageUnit();

    public BookedStorageUnit saveBookedStorageUnit(BookedStorageUnit bookedStorageUnit) throws StorageUnitAlreadyExistsException;

    public boolean deleteBookedStorageUnit(int id) throws StorageUnitNotFoundException;

    public List<BookedStorageUnit> OneMailHistory(String userMailId);
}

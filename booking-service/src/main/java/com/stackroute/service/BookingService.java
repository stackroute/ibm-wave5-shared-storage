package com.stackroute.service;

import com.stackroute.model.History;

import java.util.List;

public interface BookingService {

    public History saveHistory(History history) throws Exception;

    public boolean deleteHistory(int id) throws Exception;

    // public Partition savePartition(Partition partition) throws WarehouseAlreadyExistsException;
    public  List<History> getAllHistory() throws Exception;
}


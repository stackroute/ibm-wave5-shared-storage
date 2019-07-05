package com.stackroute.service;

import com.stackroute.model.History;

import java.util.List;

public interface BookingService {

    public History saveHistory(History history) throws Exception;

    public boolean deleteHistory(int id) throws Exception;

    public  List<History> getAllHistory() throws Exception;
}


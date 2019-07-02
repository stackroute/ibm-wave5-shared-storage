package com.stackroute.service;

import com.stackroute.domain.History;
import com.stackroute.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    HistoryRepository historyRepository;


    @Autowired
    public BookingServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }


    @Override
    public History saveHistory(History history) throws Exception {

        if (historyRepository.existsById(history.getWarehouseId())) {
            throw new Exception("warehouse already exists with id:[" + history.getWarehouseId() + "]");
        }
        History savedHistory = historyRepository.save(history);
        return savedHistory;
    }


    @Override
    public boolean deleteHistory(int id) throws Exception {
        boolean status = false;
        if (historyRepository.existsById(id)) {
            historyRepository.deleteById(id);
            status = true;
            return status;

        } else {
            throw new Exception("warehouse not exists");
        }

    }
}

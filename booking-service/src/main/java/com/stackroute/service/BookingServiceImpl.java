package com.stackroute.service;

import com.stackroute.exception.EmailDoesNotExists;
import com.stackroute.model.History;
import com.stackroute.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<History> OneMailHistory(String userMailId) throws EmailDoesNotExists {

        List<History> historyList=historyRepository.findAll();
        List<History> finalSelected = new ArrayList<>();
        for(History history:historyList){
            if(history.getUserMailId().equals(userMailId)){
                finalSelected.add(history);

            }

        }
        return finalSelected;
    }



    @Override
    public History saveHistory(History history) throws Exception {

        if (historyRepository.existsById(history.getPid())) {
            throw new Exception("partition already exists with id:[" + history.getPid() + "]");
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

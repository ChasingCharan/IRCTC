package com.example.IRCTC.service;

import com.example.IRCTC.model.Train;
import com.example.IRCTC.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public String addTrain(Train train) {
        Train saveTrain = trainRepository.save(train);
        return "Train Saved Successfully ";
    }
}

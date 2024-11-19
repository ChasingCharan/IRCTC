package com.example.IRCTC.service;

import com.example.IRCTC.model.Passenger;
import com.example.IRCTC.model.Train;
import com.example.IRCTC.repository.PassengerRepository;
import com.example.IRCTC.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TrainRepository trainRepository;

    public String addPassenger(Passenger passenger) {
        Passenger savePassenger = passengerRepository.save(passenger);
        return " Passenger Saved Successfully";
    }

    public int findPassengerXtoY(String source, Date date, String destination) {
        List<Train> trains = trainRepository.bySourceAndDestination(source,destination);

        int ct =0;
        for(Train train : trains){
            List<Passenger> passengers = passengerRepository.findByTrainIdAndDate(train.getTrainId(), date);
            ct += passengers.size();
        }
        return ct;
    }

    public int findTotalFemales(int minAge, int maxAge, String destination) {
        List<Train> trains = trainRepository.bySourceAndDestination(destination);

        int ct =0;
        for(Train train : trains){
            List<Passenger> passengers = passengerRepository.findByPassengersOfFemales(minAge,maxAge);
            ct += passengers.size();
        }
        return ct;
    }
}

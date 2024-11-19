package com.example.IRCTC.service;

import com.example.IRCTC.model.FoodOrder;
import com.example.IRCTC.model.Passenger;
import com.example.IRCTC.repository.FoodOrderRepository;
import com.example.IRCTC.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class FoodOrderService {

    @Autowired
    FoodOrderRepository foodOrderRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public String addOrder(FoodOrder foodOrder) {
        FoodOrder savedResponse = foodOrderRepository.save(foodOrder);
        return "FoodOrder Saved Successfully";
    }

    public Double findPriceOfOrders(int trainId, Date date) {

        List<Passenger> passengers = passengerRepository.findByTrainIdAndDate(trainId,date);

        double totalAmount = 0;

        for(Passenger passenger : passengers){
            List<FoodOrder> foodOrders = foodOrderRepository.findByTicketId(passenger.getTicketId());
            for (FoodOrder order : foodOrders) {
                System.out.println(order.getPrice());
                totalAmount += order.getPrice();
            }
        }
        return totalAmount;
    }
}

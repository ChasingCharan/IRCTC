package com.example.IRCTC.controller;

import com.example.IRCTC.model.FoodOrder;
import com.example.IRCTC.model.Passenger;
import com.example.IRCTC.service.FoodOrderService;
import com.example.IRCTC.service.PassengerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@RestController
@RequestMapping("/api/v1/food")
public class FoodOrderController {
    @Autowired
    FoodOrderService foodOrderService;

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody FoodOrder foodOrder){
        String response = foodOrderService.addOrder(foodOrder);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<Double> findPriceOfOrders(@RequestParam int trainId,
                                                    @RequestParam Date date){
        Double Amount = foodOrderService.findPriceOfOrders(trainId,date);
        return new ResponseEntity<>(Amount,HttpStatus.CREATED);

    }

}

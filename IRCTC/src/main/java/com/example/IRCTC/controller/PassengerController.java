package com.example.IRCTC.controller;

import com.example.IRCTC.model.Passenger;
import com.example.IRCTC.model.Train;
import com.example.IRCTC.service.PassengerService;
import com.example.IRCTC.service.TrainService;
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
@RequestMapping("/api/v1/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @PostMapping
    public ResponseEntity<String> addPassenger(@RequestBody Passenger passenger){
        String response = passengerService.addPassenger(passenger);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/city")
    public ResponseEntity<Integer> findPassengerXtoY(@RequestParam String source,
                                                     @RequestParam String destination,
                                                     @RequestParam Date date){
        int count = passengerService.findPassengerXtoY(source,date,destination);
        return new ResponseEntity<>(count, HttpStatus.CREATED);
    }

    @GetMapping("/female")
    public ResponseEntity<Integer> findTotalFemales(@RequestParam int minAge,
                                                    @RequestParam int maxAge,
                                                    @RequestParam String destination){
        int count = passengerService.findTotalFemales(minAge,maxAge,destination);
        return new ResponseEntity<>(count, HttpStatus.CREATED);

    }

}

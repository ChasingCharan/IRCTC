package com.example.IRCTC.controller;

import com.example.IRCTC.model.Train;
import com.example.IRCTC.service.TrainService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@RestController
@RequestMapping("/api/v1/train")
public class TrainController {
    @Autowired
    TrainService trainService;

    @PostMapping
    public ResponseEntity<String> addTrain(@RequestBody Train train){
        String response = trainService.addTrain(train);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}

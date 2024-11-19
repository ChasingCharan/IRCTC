package com.example.IRCTC.repository;

import com.example.IRCTC.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

    @Query("select p from Passenger p where p.trainId = :trainId and p.date = :date")
    List<Passenger> findByTrainIdAndDate(int trainId, Date date);

    @Query("select p from Passenger p where p.age >= :minAge and p.age <= :maxAge")
    List<Passenger> findByPassengersOfFemales(int minAge, int maxAge);
}

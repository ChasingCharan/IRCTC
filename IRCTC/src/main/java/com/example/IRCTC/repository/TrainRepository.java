package com.example.IRCTC.repository;

import com.example.IRCTC.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {

    @Query("select t from Train t where t.source = :source and t.destination = :destination")
    List<Train> bySourceAndDestination(String source, String destination);

    @Query("select t from Train t where t.destination = :destination")
    List<Train> bySourceAndDestination(String destination);
}

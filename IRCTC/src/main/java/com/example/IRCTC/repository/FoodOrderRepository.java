package com.example.IRCTC.repository;

import com.example.IRCTC.model.FoodOrder;
import com.example.IRCTC.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {


    @Query("select f  from FoodOrder f where f.ticketId = :ticketId")
    List<FoodOrder> findByTicketId(int ticketId);
}

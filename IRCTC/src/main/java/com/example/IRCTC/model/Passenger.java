package com.example.IRCTC.model;

import com.example.IRCTC.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder

public class Passenger {

    @Id
    int ticketId;

    int trainId;

    Date date;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

}

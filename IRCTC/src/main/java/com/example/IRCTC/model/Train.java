package com.example.IRCTC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder

public class Train {

    @Id
    int trainId;
    String source;
    String destination;
}

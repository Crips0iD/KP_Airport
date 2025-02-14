package com.example.airpot.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "airports")
public class airport1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AirportID;

    private String name;

    private String city;

    private String country;

    public airport1() {
    }

    public Long getId() {
        return AirportID;
    }

public void setId(Long AirportID) {
    this.AirportID = AirportID;
}
}





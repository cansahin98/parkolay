package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public",name="parking_space")
@Setter
@Getter
public class ParkingSpace {
    @Id
    private long id;
    private String description;
    @Column(name = "is_empty")
    private boolean isEmpty;
    private String floor;

}

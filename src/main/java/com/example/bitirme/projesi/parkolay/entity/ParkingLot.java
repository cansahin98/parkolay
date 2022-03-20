package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.parsing.Location;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public",name="parking_lot")
@Setter
@Getter
public class ParkingLot {
    @Id
    private Long id;
    private String name;
    @Column(name = "price_by_hour")
    private int priceByHour;
    private String location;
}

package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public",name="parking_history")
@Setter
@Getter
public class ParkingHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "check_in_date")
    private Date checkInDate;
    @Column(name = "check_out_date")
    private Date  checkOutDate;
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;
    @Column(name = "price_amount")
    private int priceAmount;
    @ManyToOne
    @JoinColumn(name = "license_plate_id")
    private LicensePlate licensePlate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public",name="saved_user_parking_lot")
@Setter
@Getter
public class UserSavedParkingLot {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_INFO_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PARKING_LOT_ID")
    private ParkingLot parkingLot;
}

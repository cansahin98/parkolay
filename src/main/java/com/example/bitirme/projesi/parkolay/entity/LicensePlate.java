package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public",name="license_plate")
@Setter
@Getter
public class LicensePlate {
    @Id
    private long id;
    @Column(name = "license_plate_data")
    private String licensePlateData;



}

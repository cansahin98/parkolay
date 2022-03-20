package com.example.bitirme.projesi.parkolay.entity;

import com.mysql.cj.jdbc.BlobFromLocator;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public",name="license_plate")
@Setter
@Getter
public class LicensePlate {
    @Id
    private Long id;
    @Column(name = "license_plate_data")
    private String licensePlateData;



}

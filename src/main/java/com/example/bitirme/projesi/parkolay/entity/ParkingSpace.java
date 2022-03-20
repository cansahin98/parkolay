package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(schema = "public",name="parking_space")
@Setter
@Getter
public class ParkingSpace {
    @Id
    private Long id;
    private String description;

    @Column(name = "is_empty", nullable = false, columnDefinition = "TINYINT(1)", length = 1)
    //@Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isEmpty;

    private String floor;

}

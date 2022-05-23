package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;
import org.dom4j.util.StringUtils;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(schema = "public",name="parking_space")
@Setter
@Getter
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;

    //@Column(name = "is_empty", nullable = false, columnDefinition = "TINYINT(1)", length = 1)
    //@Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_empty")
    private Integer isVacant;

    private String floor;

}

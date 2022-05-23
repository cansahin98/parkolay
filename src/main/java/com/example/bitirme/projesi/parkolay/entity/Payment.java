package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public",name="payment")
@Setter
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "card_number")
    private int cardNumber;
    @Column(name = "written_name")
    private String  writtenName;
    @Column(name = "expiration_date")
    private Date expirationDate;
    private int ccv;
}

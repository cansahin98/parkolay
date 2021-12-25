package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(schema = "public",name="payment")
@Setter
@Getter
public class Payment {
    @Id
    private long id;
    @Column(name = "card_number")
    private int cardNumber;
    @Column(name = "written_name")
    private String  writtenName;
    @Column(name = "expiration_date")
    private Date expirationDate;
    private int ccv;
}

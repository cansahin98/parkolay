package com.example.bitirme.projesi.parkolay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public",name="user_info")
@Setter
@Getter
public class User {
    @Id
    private Long id;
    private String mail;
    private String password;
    private String name;
    @Column(name = "is_parked")
    private boolean isParked;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;


}

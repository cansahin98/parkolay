package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}

package com.example.bitirme.projesi.parkolay.service;


import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.PaymentDTO;
import com.example.bitirme.projesi.parkolay.entity.Payment;

import java.util.Optional;

public interface PaymentService {
    Payment savePayment(PaymentDTO paymentDTO);
    Optional<Payment> findPayment(Long id);
}

package com.example.bitirme.projesi.parkolay.service.impl;

import com.example.bitirme.projesi.parkolay.dto.PaymentDTO;
import com.example.bitirme.projesi.parkolay.entity.Payment;
import com.example.bitirme.projesi.parkolay.mapper.ParkingSpaceDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.PaymentDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.ParkingSpaceRepository;
import com.example.bitirme.projesi.parkolay.repo.PaymentRepository;
import com.example.bitirme.projesi.parkolay.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repo;
    private final PaymentDTOMapper mapper;


    @Override
    public Payment savePayment(PaymentDTO paymentDTO) {
        return repo.save(mapper.convertToEntity(paymentDTO));
    }

    @Override
    public Optional<Payment> findPayment(Long id) {
        return repo.findById(id);
    }
}

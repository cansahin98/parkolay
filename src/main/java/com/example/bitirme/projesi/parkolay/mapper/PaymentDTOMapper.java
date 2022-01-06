package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.PaymentDTO;
import com.example.bitirme.projesi.parkolay.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentDTOMapper {
    public PaymentDTO map(Payment payment)
    {
        return PaymentDTO.Builder.PaymentWith()
                .id(payment.getId())
                .cardNumber(payment.getCardNumber())
                .writtenName(payment.getWrittenName())
                .expirationDate(payment.getExpirationDate())
                .ccv(payment.getCcv())
                .build();
    }

    public List<PaymentDTO> mapList(List<Payment> paymentList) {
        List<PaymentDTO> mapList = new ArrayList<>();
        for (Payment payment : paymentList) {
            mapList.add(this.map(payment));
        }
        return mapList;
    }

    public Payment convertToEntity(PaymentDTO paymentDTO) {
        return PaymentDTO.Builder.PaymentWith().convertToEntity(paymentDTO);
    }
}

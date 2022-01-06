package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.Payment;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


import java.util.Date;

@Getter
public class PaymentDTO {
    private long id;
    private int cardNumber;
    private String  writtenName;
    private Date expirationDate;
    private int ccv;

    public PaymentDTO() {
    }

    private PaymentDTO(Builder builder){
        this.id = builder.id;
        this.cardNumber = builder.cardNumber;
        this.writtenName = builder.writtenName;
        this.expirationDate = builder.expirationDate;
        this.ccv = builder.ccv;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


    public static class Builder {
        private long id;
        private int cardNumber;
        private String  writtenName;
        private Date expirationDate;
        private int ccv;

        private Builder() {
        }

        private Builder(PaymentDTO paymentDTO)
        {
            this.id = paymentDTO.id;
            this.cardNumber = paymentDTO.cardNumber;
            this.writtenName = paymentDTO.writtenName;
            this.expirationDate = paymentDTO.expirationDate;
            this.ccv = paymentDTO.ccv;
        }

        public static Builder PaymentWith()
        {
            return new Builder();
        }
        public static Builder PaymentWith(PaymentDTO paymentDTO)
        {
            return new Builder(paymentDTO);
        }
        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder cardNumber(final int cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }
        public Builder writtenName(final String writtenName) {
            this.writtenName = writtenName;
            return this;
        }
        public Builder expirationDate(final Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }
        public Builder ccv(final int ccv) {
            this.ccv = ccv;
            return this;
        }

        public Payment convertToEntity(PaymentDTO paymentDTO)
        {
            Payment payment = new Payment();
            payment.setId(paymentDTO.id);
            payment.setWrittenName(paymentDTO.writtenName);
            payment.setCardNumber(paymentDTO.cardNumber);
            payment.setExpirationDate(paymentDTO.expirationDate);
            payment.setCcv(paymentDTO.ccv);

            return payment;
        }

        public PaymentDTO build() {
            return new PaymentDTO(this);
        }
    }

}

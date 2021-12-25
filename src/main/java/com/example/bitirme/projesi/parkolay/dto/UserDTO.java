package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.Payment;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.PaymentDTOMapper;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
public class UserDTO {
    private long id;
    private String mail;
    private String password;
    private String name;
    private boolean isParked;
    private ParkingLotDTO parkingLot;
    private PaymentDTO payment;

    public UserDTO() {
    }

    private UserDTO(Builder builder)
    {
        this.id = builder.id;
        this.mail = builder.mail;
        this.password = builder.password;
        this.name = builder.name;
        this.isParked = builder.isParked;
        this.parkingLot = builder.parkingLot;
        this.payment = builder.payment;
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
        private String mail;
        private String password;
        private String name;
        private boolean isParked;
        private ParkingLotDTO parkingLot;
        private PaymentDTO payment;

        private Builder() {

        }
        private Builder(UserDTO userDTO)
        {
            this.id = userDTO.id;
            this.mail = userDTO.mail;
            this.password = userDTO.password;
            this.name = userDTO.name;
            this.isParked = userDTO.isParked;
            this.parkingLot = userDTO.parkingLot;
            this.payment = userDTO.payment;
        }

        public static Builder UserWith() {
            return new Builder();
        }
        public static Builder UserWith(UserDTO userDTO)
        {
            return new Builder(userDTO);
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder mail(final String mail) {
            this.mail = mail;
            return this;
        }
        public Builder password(final String password) {
            this.password = password;
            return this;
        }
        public Builder name(final String name) {
            this.name = name;
            return this;
        }
        public Builder isParked(final Boolean isParked) {
            this.isParked = isParked;
            return this;
        }
        public Builder parkingLot(final ParkingLot parkingLot) {
            if(parkingLot == null){
                this.parkingLot = null;
                return this;
            }
            ParkingLotDTOMapper mapper = new ParkingLotDTOMapper();
            this.parkingLot = mapper.map(parkingLot);
            return this;
        }
        public Builder payment(final Payment payment) {
            if(payment == null){
                this.payment = null;
                return this;
            }
            PaymentDTOMapper mapper = new PaymentDTOMapper();
            this.payment = mapper.map(payment);
            return this;
        }

        public User convertToEntity(UserDTO userDTO)
        {
            User user = new User();
            user.setId(userDTO.id);
            user.setMail(userDTO.mail);
            user.setPassword(userDTO.password);
            user.setName(userDTO.name);
            user.setParked(userDTO.isParked);
            //user.setParkingLot(userDTO.parkingLot);
            //user.setPayment(userDTO.payment);

            if (userDTO.getParkingLot() == null)
            {
                user.setParkingLot(null);
            }else {
                ParkingLotDTOMapper mapper1 = new ParkingLotDTOMapper();
                user.setParkingLot(mapper1.convertToEntity(userDTO.getParkingLot()));
            }

            if (userDTO.getPayment() == null)
            {
                user.setPayment(null);
            }else {
                PaymentDTOMapper mapper2 = new PaymentDTOMapper();
                user.setPayment(mapper2.convertToEntity(userDTO.getPayment()));
            }

            return user;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }



}

package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.LicensePlate;
import com.example.bitirme.projesi.parkolay.entity.ParkingHistory;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.mapper.LicensePlateDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.UserDTOMapper;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

@Getter
public class ParkingHistoryDTO {
    private long id;
    private Date checkInDate;
    private Date  checkOutDate;
    private ParkingLotDTO parkingLot;
    private int priceAmount;
    private LicensePlateDTO licensePlate;
    private UserDTO user;

    public ParkingHistoryDTO(Builder builder)
    {
        this.id = builder.id;
        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.parkingLot = builder.parkingLot;
        this.priceAmount = builder.priceAmount;
        this.licensePlate = builder.licensePlate;
        this.user = builder.user;
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
        private Date checkInDate;
        private Date  checkOutDate;
        private ParkingLotDTO parkingLot;
        private int priceAmount;
        private LicensePlateDTO licensePlate;
        private UserDTO user;

        private Builder() {
        }

        private Builder(ParkingHistoryDTO parkingHistoryDTO)
        {
            this.id = parkingHistoryDTO.id;
            this.checkInDate = parkingHistoryDTO.checkInDate;
            this.checkOutDate = parkingHistoryDTO.checkOutDate;
            this.parkingLot = parkingHistoryDTO.parkingLot;
            this.priceAmount = parkingHistoryDTO.priceAmount;
            this.licensePlate = parkingHistoryDTO.licensePlate;
            this.user = parkingHistoryDTO.user;
        }

        public static Builder ParkingHistoryWith() {
            return new Builder();
        }
        public static Builder ParkingHistoryWith(ParkingHistoryDTO parkingHistoryDTO)
        {
            return new Builder(parkingHistoryDTO);
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder checkInDate(final Date checkInDate) {
            this.checkInDate = checkInDate;
            return this;
        }
        public Builder checkOutDate(final Date checkOutDate) {
            this.checkOutDate = checkOutDate;
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
        public Builder priceAmount(final int priceAmount) {
            this.priceAmount = priceAmount;
            return this;
        }
        public Builder licensePlate(final LicensePlate licensePlate) {
            if(licensePlate == null){
                this.licensePlate = null;
                return this;
            }
            LicensePlateDTOMapper mapper1 = new LicensePlateDTOMapper();
            this.licensePlate = mapper1.map(licensePlate);
            return this;
        }
        public Builder user(final User user) {
            if(user == null){
                this.user = null;
                return this;
            }
            UserDTOMapper mapper = new UserDTOMapper();
            this.user = mapper.map(user);
            return this;
        }

        public ParkingHistory convertToEntity(ParkingHistoryDTO parkingHistoryDTO)
        {
            ParkingHistory parkingHistory = new ParkingHistory();
            parkingHistory.setId(parkingHistoryDTO.id);
            parkingHistory.setCheckInDate(parkingHistoryDTO.checkInDate);
            parkingHistory.setCheckOutDate(parkingHistoryDTO.checkOutDate);
            parkingHistory.setPriceAmount(parkingHistoryDTO.priceAmount);
            //parkingLot
            //licensePlate
            //user

            if (parkingHistoryDTO.getParkingLot() == null)
            {
                parkingHistory.setParkingLot(null);
            }else {
                ParkingLotDTOMapper mapper1 = new ParkingLotDTOMapper();
                parkingHistory.setParkingLot(mapper1.convertToEntity(parkingHistoryDTO.getParkingLot()));
            }

            if (parkingHistoryDTO.getLicensePlate() == null)
            {
                parkingHistory.setLicensePlate(null);
            }else {
                LicensePlateDTOMapper mapper2 = new LicensePlateDTOMapper();
                parkingHistory.setLicensePlate(mapper2.convertToEntity(parkingHistoryDTO.getLicensePlate()));
            }

            if (parkingHistoryDTO.getUser() == null)
            {
                parkingHistory.setUser(null);
            }else {
                UserDTOMapper mapper3 = new UserDTOMapper();
                parkingHistory.setUser(mapper3.convertToEntity(parkingHistoryDTO.getUser()));
            }

            return parkingHistory;
        }
        public ParkingHistoryDTO build() {
            return new ParkingHistoryDTO(this);
        }


    }
}

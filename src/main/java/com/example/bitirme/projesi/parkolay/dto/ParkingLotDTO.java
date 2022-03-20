package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.mapper.ParkingSpaceDTOMapper;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
public class ParkingLotDTO {
    private long id;
    private String name;
    private int priceByHour;
    private String location;

    public ParkingLotDTO() {
    }

    public ParkingLotDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.priceByHour = builder.priceByHour;
        this.location = builder.location;
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
        private String name;
        private int priceByHour;
        private String location;

        private Builder() {
        }
        private Builder(ParkingLotDTO parkingLotDTO) {
            this.id = parkingLotDTO.id;
            this.name = parkingLotDTO.name;
            this.priceByHour = parkingLotDTO.priceByHour;
            this.location = parkingLotDTO.location;
        }

        public static Builder ParkingLotWith() {
            return new Builder();
        }

        public static Builder ParkingLotWith(ParkingLotDTO parkingLotDTO) {
            return new Builder(parkingLotDTO);
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder name(final String name) {
            this.name = name;
            return this;
        }
        public Builder priceByHour(final int priceByHour) {
            this.priceByHour = priceByHour;
            return this;
        }
        public Builder location(final String location) {
            this.location = location;
            return this;
        }

        public ParkingLot convertToEntity(ParkingLotDTO parkingLotDTO)
        {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setId(parkingLotDTO.id);
            parkingLot.setName(parkingLotDTO.name);
            parkingLot.setPriceByHour(parkingLotDTO.priceByHour);
            parkingLot.setLocation(parkingLotDTO.location);

            return parkingLot;
        }
        public ParkingLotDTO build() {
            return new ParkingLotDTO(this);
        }




    }


}

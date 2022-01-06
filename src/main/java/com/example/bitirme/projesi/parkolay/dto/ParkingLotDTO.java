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
    private ParkingSpaceDTO parkingSpace;

    public ParkingLotDTO() {
    }

    public ParkingLotDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.priceByHour = builder.priceByHour;
        this.location = builder.location;
        this.parkingSpace = builder.parkingSpace;
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
        private ParkingSpaceDTO parkingSpace;

        private Builder() {
        }
        private Builder(ParkingLotDTO parkingLotDTO) {
            this.id = parkingLotDTO.id;
            this.name = parkingLotDTO.name;
            this.priceByHour = parkingLotDTO.priceByHour;
            this.location = parkingLotDTO.location;
            this.parkingSpace = parkingLotDTO.parkingSpace;
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
        public Builder parkingSpace(final ParkingSpace parkingSpace) {
            if(parkingSpace == null){
                this.parkingSpace = null;
                return this;
            }
            ParkingSpaceDTOMapper mapper = new ParkingSpaceDTOMapper();
            this.parkingSpace = mapper.map(parkingSpace);
            return this;
        }

        public ParkingLot convertToEntity(ParkingLotDTO parkingLotDTO)
        {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setId(parkingLotDTO.id);
            parkingLot.setName(parkingLotDTO.name);
            parkingLot.setPriceByHour(parkingLotDTO.priceByHour);
            parkingLot.setLocation(parkingLotDTO.location);
            //parkingSpace

            if (parkingLotDTO.getParkingSpace() == null)
            {
                parkingLot.setParkingSpace(null);
            }else {
                ParkingSpaceDTOMapper mapper = new ParkingSpaceDTOMapper();
                parkingLot.setParkingSpace(mapper.convertToEntity(parkingLotDTO.getParkingSpace()));
            }

            return parkingLot;
        }
        public ParkingLotDTO build() {
            return new ParkingLotDTO(this);
        }




    }


}

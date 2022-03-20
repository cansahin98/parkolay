package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.ParkingSpaceDTOMapper;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
public class ParkingLotParkingSpaceDTO {
    private Long id;
    private ParkingLotDTO parkingLot;
    private ParkingSpaceDTO parkingSpace;

    public ParkingLotParkingSpaceDTO() {
    }

    private ParkingLotParkingSpaceDTO(Builder builder)
    {
        this.id = builder.id;
        this.parkingLot = builder.parkingLot;
        this.parkingSpace = builder.parkingSpace;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


    public static class Builder {
        private Long id;
        private ParkingLotDTO parkingLot;
        private ParkingSpaceDTO parkingSpace;

        private Builder(){
        }

        private Builder(ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO)
        {
            this.id = parkingLotParkingSpaceDTO.id;
            this.parkingLot = parkingLotParkingSpaceDTO.parkingLot;
            this.parkingSpace = parkingLotParkingSpaceDTO.parkingSpace;
        }
        public static Builder ParkingLotParkingSpaceWith()
        {
            return new Builder();
        }

        public static Builder ParkingLotParkingSpaceWith(ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO)
        {
            return new Builder(parkingLotParkingSpaceDTO);
        }

        public Builder id(final Long id)
        {
            this.id = id;
            return this;
        }

        public Builder parkingLot(final ParkingLot parkingLot){
            if (parkingLot == null)
            {
                this.parkingLot = null;
                return this;
            }
            ParkingLotDTOMapper mapper = new ParkingLotDTOMapper();
            this.parkingLot = mapper.map(parkingLot);
            return this;
        }

        public Builder parkingSpace(final ParkingSpace parkingSpace)
        {
            if (parkingSpace == null)
            {
                this.parkingSpace = null;
                return this;
            }
            ParkingSpaceDTOMapper mapper = new ParkingSpaceDTOMapper();
            this.parkingSpace = mapper.map(parkingSpace);
            return this;
        }

        public ParkingLotParkingSpace convertToEntity(ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO)
        {
            ParkingLotParkingSpace parkingLotParkingSpace = new ParkingLotParkingSpace();
            parkingLotParkingSpace.setId(parkingLotParkingSpaceDTO.id);

            if (parkingLotParkingSpaceDTO.getParkingLot() == null)
            {
                parkingLotParkingSpace.setParkingLot(null);
            }else {
                ParkingLotDTOMapper mapper = new ParkingLotDTOMapper();
                parkingLotParkingSpace.setParkingLot(mapper.convertToEntity(parkingLotParkingSpaceDTO.getParkingLot()));
            }

            if (parkingLotParkingSpaceDTO.getParkingSpace() == null)
            {
                parkingLotParkingSpace.setParkingSpace(null);
            }else {
                ParkingSpaceDTOMapper mapper = new ParkingSpaceDTOMapper();
                parkingLotParkingSpace.setParkingSpace(mapper.convertToEntity(parkingLotParkingSpaceDTO.getParkingSpace()));
            }

            return parkingLotParkingSpace;
        }

        public ParkingLotParkingSpaceDTO build()
        {
            return new ParkingLotParkingSpaceDTO(this);
        }
    }




}

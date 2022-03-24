package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
public class ParkingSpaceDTO {
    private long id;
    private String description;
    private Integer isVacant;
    private String floor;

    public ParkingSpaceDTO(){
    }
    public ParkingSpaceDTO(Builder builder){
        this.id = builder.id;
        this.description = builder.description;
        this.isVacant = builder.isVacant;
        this.floor = builder.floor;
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
        private String description;
        private Integer isVacant;
        private String floor;

        private Builder() {
        }
        private Builder(ParkingSpaceDTO parkingSpaceDTO)
        {
            this.id = parkingSpaceDTO.id;
            this.description = parkingSpaceDTO.description;
            this.isVacant = parkingSpaceDTO.isVacant;
            this.floor = parkingSpaceDTO.floor;
        }

        public static Builder ParkingSpaceWith() {
            return new Builder();
        }
        public static Builder ParkingSpaceWith(ParkingSpaceDTO parkingSpaceDTO)
        {
            return new Builder(parkingSpaceDTO);
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder description(final String description) {
            this.description = description;
            return this;
        }
        public Builder isVacant(final Integer isVacant) {
            this.isVacant = isVacant;
            return this;
        }
        public Builder floor(final String floor) {
            this.floor = floor;
            return this;
        }

        public ParkingSpace convertToEntity(ParkingSpaceDTO parkingSpaceDTO)
        {
            ParkingSpace parkingSpace = new ParkingSpace();
            parkingSpace.setId(parkingSpaceDTO.id);
            parkingSpace.setDescription(parkingSpaceDTO.description);
            parkingSpace.setIsVacant(parkingSpaceDTO.isVacant);
            parkingSpace.setFloor(parkingSpaceDTO.floor);

            return parkingSpace;
        }

        public ParkingSpaceDTO build() {
            return new ParkingSpaceDTO(this);
        }

    }
}

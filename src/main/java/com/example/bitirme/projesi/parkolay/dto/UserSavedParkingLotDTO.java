package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.entity.UserSavedParkingLot;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.UserDTOMapper;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


@Getter
public class UserSavedParkingLotDTO {
    private Long id;
    private UserDTO user;
    private ParkingLotDTO parkingLot;

    public UserSavedParkingLotDTO() {
    }

    private UserSavedParkingLotDTO(Builder builder)
    {
        this.id = builder.id;
        this.parkingLot = builder.parkingLot;
        this.user = builder.user;
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
        private UserDTO user;
        private ParkingLotDTO parkingLot;

        private Builder(){
        }

        private Builder(UserSavedParkingLotDTO userSavedParkingLotDTO)
        {
            this.id = userSavedParkingLotDTO.id;
            this.parkingLot = userSavedParkingLotDTO.parkingLot;
            this.user = userSavedParkingLotDTO.user;
        }

        public static Builder UserSavedParkingLotWith(){
            return new Builder();
        }
        public static Builder UserSavedParkingLotWith(UserSavedParkingLotDTO userSavedParkingLotDTO)
        {
            return new Builder(userSavedParkingLotDTO);
        }
        public Builder id(final Long id)
        {
            this.id = id;
            return this;
        }
        public Builder parkingLot(final ParkingLot parkingLot)
        {
            if (parkingLot == null)
            {
                this.parkingLot = null;
                return this;
            }
            ParkingLotDTOMapper mapper = new ParkingLotDTOMapper();
            this.parkingLot = mapper.map(parkingLot);
            return this;
        }
        public Builder user(final User user)
        {
            if (user == null)
            {
                this.user = null;
                return this;
            }
            UserDTOMapper mapper = new UserDTOMapper();
            this.user = mapper.map(user);
            return this;
        }

        public UserSavedParkingLot convertToEntity(UserSavedParkingLotDTO userSavedParkingLotDTO)
        {
            UserSavedParkingLot userSavedParkingLot = new UserSavedParkingLot();
            userSavedParkingLot.setId(userSavedParkingLotDTO.id);
            //userSavedParkingLot.setUser(userSavedParkingLotDTO.user);
            if (userSavedParkingLotDTO.getUser() == null)
            {
                userSavedParkingLot.setUser(null);
            }else {
                UserDTOMapper mapper1 = new UserDTOMapper();
                userSavedParkingLot.setUser(mapper1.convertToEntity(userSavedParkingLotDTO.getUser()));
            }

            if (userSavedParkingLotDTO.getParkingLot() == null)
            {
                userSavedParkingLot.setParkingLot(null);
            }else {
                ParkingLotDTOMapper mapper2 = new ParkingLotDTOMapper();
                userSavedParkingLot.setParkingLot(mapper2.convertToEntity(userSavedParkingLotDTO.getParkingLot()));
            }

            return userSavedParkingLot;
        }

        public UserSavedParkingLotDTO build()
        {
            return new UserSavedParkingLotDTO(this);
        }
    }
}

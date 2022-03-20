package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.UserSavedParkingLotDTO;
import com.example.bitirme.projesi.parkolay.entity.UserSavedParkingLot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserSavedParkingLotDTOMapper {
    public UserSavedParkingLotDTO map(UserSavedParkingLot userSavedParkingLot)
    {
        return UserSavedParkingLotDTO.Builder.UserSavedParkingLotWith()
                .id(userSavedParkingLot.getId())
                .parkingLot(userSavedParkingLot.getParkingLot())
                .user(userSavedParkingLot.getUser())
                .build();
    }

    public List<UserSavedParkingLotDTO> mapList(List<UserSavedParkingLot> userSavedParkingLotList)
    {
        List<UserSavedParkingLotDTO> mapList = new ArrayList<>();
        for (UserSavedParkingLot userSavedParkingLot : userSavedParkingLotList)
        {
            mapList.add(this.map(userSavedParkingLot));
        }
        return mapList;
    }
    public UserSavedParkingLot convertToEntity(UserSavedParkingLotDTO userSavedParkingLotDTO)
    {
        return UserSavedParkingLotDTO.Builder.UserSavedParkingLotWith().convertToEntity(userSavedParkingLotDTO);
    }
}

package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.ParkingHistoryDTO;
import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingHistory;
import com.example.bitirme.projesi.parkolay.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParkingHistoryDTOMapper {
    public ParkingHistoryDTO map(ParkingHistory parkingHistory)
    {
        return ParkingHistoryDTO.Builder.ParkingHistoryWith()
                .id(parkingHistory.getId())
                .checkInDate(parkingHistory.getCheckInDate())
                .checkOutDate(parkingHistory.getCheckOutDate())
                .parkingLot(parkingHistory.getParkingLot())
                .priceAmount(parkingHistory.getPriceAmount())
                .licensePlate(parkingHistory.getLicensePlate())
                .user(parkingHistory.getUser())
                .build();
    }
    public List<ParkingHistoryDTO> mapList(List<ParkingHistory> parkingHistoryList)
    {
        List<ParkingHistoryDTO> mapList = new ArrayList<>();
        for (ParkingHistory parkingHistory : parkingHistoryList)
        {
            mapList.add(this.map(parkingHistory));
        }
        return mapList;

    }
    public ParkingHistory convertToEntity(ParkingHistoryDTO parkingHistoryDTO) {
        return ParkingHistoryDTO.Builder.ParkingHistoryWith().convertToEntity(parkingHistoryDTO);
    }
}

package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParkingLotDTOMapper {
    public ParkingLotDTO map(ParkingLot parkingLot)
    {
        return ParkingLotDTO.Builder.ParkingLotWith()
                .id(parkingLot.getId())
                .name(parkingLot.getName())
                .priceByHour(parkingLot.getPriceByHour())
                .location(parkingLot.getLocation())
                .parkingSpace(parkingLot.getParkingSpace())
                .build();
    }

    public List<ParkingLotDTO> mapList(List<ParkingLot> parkingLotList)
    {
        List<ParkingLotDTO> mapList = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLotList)
        {
            mapList.add(this.map(parkingLot));
        }
        return mapList;
    }

    public ParkingLot convertToEntity(ParkingLotDTO parkingLotDTO) {
        return ParkingLotDTO.Builder.ParkingLotWith().convertToEntity(parkingLotDTO);
    }
}

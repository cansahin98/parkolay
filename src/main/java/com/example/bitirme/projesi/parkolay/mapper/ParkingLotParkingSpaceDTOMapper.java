package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParkingLotParkingSpaceDTOMapper {
    public ParkingLotParkingSpaceDTO map(ParkingLotParkingSpace parkingLotParkingSpace)
    {
        return ParkingLotParkingSpaceDTO.Builder.ParkingLotParkingSpaceWith()
                .parkingLot(parkingLotParkingSpace.getParkingLot())
                .parkingSpace(parkingLotParkingSpace.getParkingSpace())
                .build();
    }

    public List<ParkingLotParkingSpaceDTO> mapList(List<ParkingLotParkingSpace> parkingLotParkingSpaceList)
    {
        List<ParkingLotParkingSpaceDTO> mapList = new ArrayList<>();
        for (ParkingLotParkingSpace parkingLotParkingSpace : parkingLotParkingSpaceList)
        {
            mapList.add(this.map(parkingLotParkingSpace));
        }
        return mapList;
    }

    public ParkingLotParkingSpace convertToEntity(ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO)
    {
        return ParkingLotParkingSpaceDTO.Builder.ParkingLotParkingSpaceWith().convertToEntity(parkingLotParkingSpaceDTO);
    }
}

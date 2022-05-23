package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParkingSpaceDTOMapper {
    public ParkingSpaceDTO map(ParkingSpace parkingSpace)
    {
        return ParkingSpaceDTO.Builder.ParkingSpaceWith()
                .id(parkingSpace.getId())
                .description(parkingSpace.getDescription())
                .isVacant(parkingSpace.getIsVacant())
                .floor(parkingSpace.getFloor())
                .build();
    }

    public List<ParkingSpaceDTO> mapList(List<ParkingSpace> parkingSpaceList)
    {
        List<ParkingSpaceDTO> mapList = new ArrayList<>();
        for (ParkingSpace parkingSpace : parkingSpaceList)
        {
            mapList.add(this.map(parkingSpace));
        }
        return mapList;
    }

    public ParkingSpace convertToEntity(ParkingSpaceDTO parkingSpaceDTO) {
        return ParkingSpaceDTO.Builder.ParkingSpaceWith().convertToEntity(parkingSpaceDTO);
    }

}

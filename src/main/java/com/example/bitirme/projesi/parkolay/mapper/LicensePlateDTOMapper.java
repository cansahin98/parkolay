package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.LicensePlateDTO;
import com.example.bitirme.projesi.parkolay.entity.LicensePlate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LicensePlateDTOMapper {
    public LicensePlateDTO map(LicensePlate licensePlate)
    {
        return LicensePlateDTO.Builder.LicensePlateWith()
                .id(licensePlate.getId())
                .licensePlateData(licensePlate.getLicensePlateData())
                .build();
    }

    public List<LicensePlateDTO> mapList(List<LicensePlate> licensePlateList)
    {
        List<LicensePlateDTO> mapList = new ArrayList<>();
        for (LicensePlate licensePlate : licensePlateList)
        {
            mapList.add(this.map(licensePlate));
        }
        return mapList;
    }

    public LicensePlate convertToEntity(LicensePlateDTO licensePlateDTO)
    {
        return LicensePlateDTO.Builder.LicensePlateWith().convertToEntity(licensePlateDTO);
    }

}

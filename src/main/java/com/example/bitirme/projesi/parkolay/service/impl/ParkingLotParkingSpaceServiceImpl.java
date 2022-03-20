package com.example.bitirme.projesi.parkolay.service.impl;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotParkingSpaceDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.ParkingLotParkingSpaceRepository;
import com.example.bitirme.projesi.parkolay.service.ParkingLotParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingLotParkingSpaceServiceImpl implements ParkingLotParkingSpaceService {
    private final ParkingLotParkingSpaceRepository repo;
    private final ParkingLotParkingSpaceDTOMapper mapper;

    @Override
    public ParkingLotParkingSpace save(ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO) {
        return repo.save(mapper.convertToEntity(parkingLotParkingSpaceDTO));
    }
}

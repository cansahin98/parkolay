package com.example.bitirme.projesi.parkolay.service.impl;

import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.mapper.ParkingSpaceDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.ParkingSpaceRepository;
import com.example.bitirme.projesi.parkolay.service.ParkingSapceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingSpaceServiceImpl implements ParkingSapceService {
    private final ParkingSpaceRepository repo;
    private final ParkingSpaceDTOMapper mapper;

    @Override
    public ParkingSpace saveParkingSpace(ParkingSpaceDTO parkingSpaceDTO) {
        return repo.save(mapper.convertToEntity(parkingSpaceDTO));
    }
}

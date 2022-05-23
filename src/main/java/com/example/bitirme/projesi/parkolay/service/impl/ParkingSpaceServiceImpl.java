package com.example.bitirme.projesi.parkolay.service.impl;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotParkingSpaceDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.ParkingSpaceDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.ParkingLotParkingSpaceRepository;
import com.example.bitirme.projesi.parkolay.repo.ParkingSpaceRepository;
import com.example.bitirme.projesi.parkolay.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    private final ParkingSpaceRepository repo;
    private final ParkingSpaceDTOMapper mapper;

    private final ParkingLotParkingSpaceDTOMapper parkingLotParkingSpaceDTOMapper;
    private final ParkingLotParkingSpaceRepository parkingLotParkingSpaceRepo;

    @Override
    public ParkingSpace saveParkingSpace(ParkingSpaceDTO parkingSpaceDTO) {
        return repo.save(mapper.convertToEntity(parkingSpaceDTO));
    }

    @Override
    public ParkingSpace setSpotVacantByParkingLotIdAndDescription(Long parkingLotId, String description) {
        ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO = parkingLotParkingSpaceDTOMapper
                .map(parkingLotParkingSpaceRepo.findParkingLotParkingSpaceByParkingLot_IdAndParkingSpace_Description(parkingLotId, description));
        ParkingSpaceDTO parkingSpaceDTO = ParkingSpaceDTO.Builder.ParkingSpaceWith(parkingLotParkingSpaceDTO.getParkingSpace()).isVacant(1).build();
        return repo.save(mapper.convertToEntity(parkingSpaceDTO));
    }

    @Override
    public ParkingSpace setSpotFullByParkingLotIdAndDescription(Long parkingLotId, String description) {
        ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO = parkingLotParkingSpaceDTOMapper
                .map(parkingLotParkingSpaceRepo.findParkingLotParkingSpaceByParkingLot_IdAndParkingSpace_Description(parkingLotId, description));
        ParkingSpaceDTO parkingSpaceDTO = ParkingSpaceDTO.Builder.ParkingSpaceWith(parkingLotParkingSpaceDTO.getParkingSpace()).isVacant(0).build();
        return repo.save(mapper.convertToEntity(parkingSpaceDTO));
    }
}

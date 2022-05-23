package com.example.bitirme.projesi.parkolay.service.impl;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.dto.ParkingLotParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.UserSavedParkingLotDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotParkingSpaceDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.ParkingLotParkingSpaceRepository;
import com.example.bitirme.projesi.parkolay.repo.ParkingLotRepository;
import com.example.bitirme.projesi.parkolay.repo.ParkingSpaceRepository;
import com.example.bitirme.projesi.parkolay.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository repo;
    private final ParkingLotDTOMapper mapper;

    private final ParkingLotParkingSpaceRepository parkingLotParkingSpaceRepo;
    private final ParkingLotParkingSpaceDTOMapper parkingLotParkingSpaceDTOMapper;


    @Override
    public List<ParkingLot> listAll() {
        return (List<ParkingLot>) repo.findAll();
    }

    @Override
    public Optional<ParkingLot> findParkingLot(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ParkingSpaceDTO> listAllParkingSpacesByParkingLotId(Long parkingLotId) {
        List<ParkingLotParkingSpaceDTO> parkingLotParkingSpaceDTOList = parkingLotParkingSpaceDTOMapper.mapList(parkingLotParkingSpaceRepo.findAllByParkingLot_Id(parkingLotId));
        List<ParkingSpaceDTO> parkingSpaceDTOList = new ArrayList<>();
        for (ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO : parkingLotParkingSpaceDTOList)
        {
            parkingSpaceDTOList.add(parkingLotParkingSpaceDTO.getParkingSpace());
        }

        return parkingSpaceDTOList;
    }

    @Override
    public ParkingLot saveParkingSpace(ParkingLotDTO parkingLotDTO) {
        return repo.save(mapper.convertToEntity(parkingLotDTO));
    }

    @Override
    public String calculatePercentage(Long parkingLotId) {
        List<ParkingSpaceDTO> parkingSpaceDTOList = listAllParkingSpacesByParkingLotId(parkingLotId);
        Integer counterOfParkingSpaces = parkingSpaceDTOList.size();
        Integer counterOfVacantParkingSpaces = listAllVacantParkingSpacesByParkingLotId(parkingLotId).size();
        Float counterOfOccupiedParkingSpaces = 100 - (counterOfVacantParkingSpaces.floatValue()) / (counterOfParkingSpaces.floatValue()) * 100;
        return "%" + counterOfOccupiedParkingSpaces;
    }

    public List<ParkingSpaceDTO> listAllVacantParkingSpacesByParkingLotId(Long parkingLotId) {
        List<ParkingLotParkingSpaceDTO> parkingLotParkingSpaceDTOList = parkingLotParkingSpaceDTOMapper.mapList(parkingLotParkingSpaceRepo.findAllByParkingLot_IdAndParkingSpace_IsVacant(parkingLotId, 1));
        List<ParkingSpaceDTO> parkingSpaceDTOList = new ArrayList<>();
        for (ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO : parkingLotParkingSpaceDTOList)
        {
            parkingSpaceDTOList.add(parkingLotParkingSpaceDTO.getParkingSpace());
        }
        return parkingSpaceDTOList;
    }
}
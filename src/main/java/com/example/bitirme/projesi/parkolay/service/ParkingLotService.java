package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;

import java.util.List;
import java.util.Optional;

public interface ParkingLotService {

    List<ParkingLot> listAll();

    Optional<ParkingLot> findParkingLot(Long id);

    List<ParkingSpaceDTO> listAllParkingSpacesByParkingLotId(Long parkingLotId);

    ParkingLot saveParkingSpace(ParkingLotDTO parkingLotDTO);

    String calculatePercentage(Long parkingLotId);
}

package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;

public interface ParkingSpaceService {
    ParkingSpace saveParkingSpace(ParkingSpaceDTO parkingSpaceDTO);

    ParkingSpace setSpotVacantByParkingLotIdAndDescription(Long parkingLotId, String description);

    ParkingSpace setSpotFullByParkingLotIdAndDescription(Long parkingLotId, String description);
}

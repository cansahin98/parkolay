package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;

public interface ParkingLotParkingSpaceService {
    ParkingLotParkingSpace save(ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO);
}

package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;

public interface ParkingSapceService {
    ParkingSpace saveParkingSpace(ParkingSpaceDTO parkingSpaceDTO);
}

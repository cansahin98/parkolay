package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.dto.UserSavedParkingLotDTO;

import java.util.List;

public interface UserSavedParkingLotService {
    List<UserSavedParkingLotDTO> listAll();
}

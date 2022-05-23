package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.entity.ParkingHistory;
import com.example.bitirme.projesi.parkolay.entity.User;

import java.util.List;

public interface ParkingHistoryService {
    ParkingHistory saveLicensePlate(Long userId, String licensePlate);

    User findUserByLicensePlate(String licensePlate);
    List<Object> checkIn(String licensePlate, Long userId);
}

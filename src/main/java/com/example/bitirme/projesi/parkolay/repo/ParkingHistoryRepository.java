package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.ParkingHistory;
import com.example.bitirme.projesi.parkolay.service.ParkingHistoryService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingHistoryRepository extends CrudRepository<ParkingHistory, Long> {
    ParkingHistory findByLicensePlate_LicensePlateData(String licensePlate);
}

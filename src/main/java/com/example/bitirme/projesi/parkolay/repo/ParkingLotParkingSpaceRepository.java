package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotParkingSpaceRepository extends CrudRepository<ParkingLotParkingSpace, Long> {
    List<ParkingLotParkingSpace> findAllByParkingLot_Id(Long parkingLotId);
    List<ParkingLotParkingSpace> findAllByParkingLot_IdAndParkingSpace_IsVacant(Long parkingLotId, Integer isParkingSpaceEmpty);
    ParkingLotParkingSpace findParkingLotParkingSpaceByParkingLot_IdAndParkingSpace_Description(Long parkingLotId, String parkingSpaceDescription);

}

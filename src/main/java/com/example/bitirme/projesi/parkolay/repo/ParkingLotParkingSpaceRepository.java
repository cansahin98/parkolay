package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.BitSet;
import java.util.List;
import java.util.function.BinaryOperator;

@Repository
public interface ParkingLotParkingSpaceRepository extends CrudRepository<ParkingLotParkingSpace, Long> {
    List<ParkingLotParkingSpace> findAllByParkingLot_Id(Long parkingLotId);
    //List<ParkingLotParkingSpace> findAllByParkingLot_IdAndParkingSpace_Empty(Long parkingLotId, Boolean isParkingSpaceEmpty); :TODO
}

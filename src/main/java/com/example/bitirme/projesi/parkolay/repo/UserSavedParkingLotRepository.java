package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.UserSavedParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSavedParkingLotRepository extends CrudRepository<UserSavedParkingLot, Long> {
    List<UserSavedParkingLot> findAllByUser_Id(Long userId);
}

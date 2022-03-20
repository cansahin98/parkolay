package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingSpaceRepository extends CrudRepository<ParkingSpace, Long> {
}

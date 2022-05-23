package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.LicensePlate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicensePlateRepository extends CrudRepository<LicensePlate, Long> {
}

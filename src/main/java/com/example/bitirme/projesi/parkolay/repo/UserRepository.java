package com.example.bitirme.projesi.parkolay.repo;

import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByMailAndPassword(String userName, String password);
    User findByMail(String mail);
}



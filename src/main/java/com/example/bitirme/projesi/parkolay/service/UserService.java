package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findUser(String mail, String password);

    User saveUser(UserDTO userDTO);

    User changePassword(Long userId, String newPassword);

    Optional<User> findUser(Long id);

    User findUserByMail(String mail);

    List<ParkingLotDTO> findParkingLotByUserId(Long userId);

}




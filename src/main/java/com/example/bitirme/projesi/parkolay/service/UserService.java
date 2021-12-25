package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.entity.User;

public interface UserService {
    User login(String mail, String password);

    User saveUser(UserDTO userDTO);
}

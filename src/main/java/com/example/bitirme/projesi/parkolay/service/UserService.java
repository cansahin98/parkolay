package com.example.bitirme.projesi.parkolay.service;

import com.example.bitirme.projesi.parkolay.dto.ResponsePayload;

public interface UserService {
    ResponsePayload login(String mail, String password);
}

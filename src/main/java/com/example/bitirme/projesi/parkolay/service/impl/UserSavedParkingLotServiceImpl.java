package com.example.bitirme.projesi.parkolay.service.impl;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.dto.UserSavedParkingLotDTO;
import com.example.bitirme.projesi.parkolay.entity.UserSavedParkingLot;
import com.example.bitirme.projesi.parkolay.mapper.UserSavedParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.UserSavedParkingLotRepository;
import com.example.bitirme.projesi.parkolay.service.UserSavedParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserSavedParkingLotServiceImpl implements UserSavedParkingLotService {
    private final UserSavedParkingLotRepository repo;
    private final UserSavedParkingLotDTOMapper mapper;



    @Override
    public List<UserSavedParkingLotDTO> listAll() {
        return mapper.mapList((List<UserSavedParkingLot>) repo.findAll());
    }
}

package com.example.bitirme.projesi.parkolay.controller;

import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.service.UserSavedParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-saved-parking-lot")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class UserSavedParkingLotController extends AbstractResponsePayload {
    private final UserSavedParkingLotService userSavedParkingLotService;

    @GetMapping(value = "/list-all")
    public ResponsePayload listAll()
    {
        return getResponse((userSavedParkingLotService.listAll()));
    }

}

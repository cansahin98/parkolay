package com.example.bitirme.projesi.parkolay.controller;

import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.enumeration.ResponseEnum;
import com.example.bitirme.projesi.parkolay.mapper.ParkingHistoryDTOMapper;
import com.example.bitirme.projesi.parkolay.service.ParkingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-history")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class ParkingHistoryController extends AbstractResponsePayload {
    ParkingHistoryDTOMapper parkingHistoryDTOMapper;
    ParkingHistoryService parkingHistoryService;

    @GetMapping(value = "/find-user-by-license-plate")
    public ResponsePayload findUserByLicensePlate(@RequestParam("license-plate") String licensePlate)
    {
        User user = parkingHistoryService.findUserByLicensePlate(licensePlate);
        if(user == null) {
            return getResponse(ResponseEnum.ERROR,"Plaka bulunamadı");
        }
        return getResponse(user);
    }
//    public ResponsePayload checkIn(@RequestParam("license-plate") String licensePlate,@RequestParam("user-id") Long userId)
//    {
//        parkingHistoryService.checkIn(licensePlate, userId);
//        return null;
//    }
}

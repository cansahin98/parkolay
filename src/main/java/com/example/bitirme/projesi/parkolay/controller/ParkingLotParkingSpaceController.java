package com.example.bitirme.projesi.parkolay.controller;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.entity.ParkingLotParkingSpace;
import com.example.bitirme.projesi.parkolay.enumeration.ResponseEnum;
import com.example.bitirme.projesi.parkolay.service.ParkingLotParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-lot-parking-space")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class ParkingLotParkingSpaceController extends AbstractResponsePayload {
    private final ParkingLotParkingSpaceService parkingLotParkingSpaceService;

    @PostMapping(value = "/save")
    public ResponsePayload saveParkingLotParkingSpace(@RequestBody ParkingLotParkingSpaceDTO parkingLotParkingSpaceDTO)
    {
        ParkingLotParkingSpace save = parkingLotParkingSpaceService.save(parkingLotParkingSpaceDTO);
        if (save == null)
        {
            return getResponse(ResponseEnum.ERROR, "Kayıt işlemi başarısız!");
        }
        setResponseEnum(ResponseEnum.OK, "Başarılı.");
        return getResponse(save);
    }
}

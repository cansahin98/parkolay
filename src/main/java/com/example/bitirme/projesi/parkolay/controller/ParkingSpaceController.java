package com.example.bitirme.projesi.parkolay.controller;

import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.enumeration.ResponseEnum;
import com.example.bitirme.projesi.parkolay.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-space")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class ParkingSpaceController extends AbstractResponsePayload {
    private final ParkingSpaceService parkingSpaceService;

    @PostMapping(value = "/save")
    public ResponsePayload saveParkingSpace(@RequestBody ParkingSpaceDTO parkingSpaceDTO)
    {
        parkingSpaceDTO = ParkingSpaceDTO.Builder.ParkingSpaceWith(parkingSpaceDTO).build();
        ParkingSpace save = parkingSpaceService.saveParkingSpace(parkingSpaceDTO);
        if (save == null)
        {
            return getResponse(ResponseEnum.ERROR, "Kayıt işlemi başarısız!");
        }
        setResponseEnum(ResponseEnum.OK, "Başarılı.");
        return getResponse(save);
    }

    @PostMapping(value = "/set-spot-vacant")
    public ResponsePayload setSpotVacantByParkingLotIdAndDescription(@RequestParam("parking-lot-id") Long parkingLotId, @RequestParam("description") String description)
    {
        return getResponse(parkingSpaceService.setSpotVacantByParkingLotIdAndDescription(parkingLotId, description));
    }

    @PostMapping(value = "/set-spot-full")
    public ResponsePayload setSpotFullByParkingLotIdAndDescription(@RequestParam("parking-lot-id") Long parkingLotId, @RequestParam("description") String description)
    {
        return getResponse(parkingSpaceService.setSpotFullByParkingLotIdAndDescription(parkingLotId, description));
    }

}

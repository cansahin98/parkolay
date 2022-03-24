package com.example.bitirme.projesi.parkolay.controller;

import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.dto.ParkingSpaceDTO;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.ParkingSpace;
import com.example.bitirme.projesi.parkolay.enumeration.ResponseEnum;
import com.example.bitirme.projesi.parkolay.mapper.ParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.ParkingSpaceDTOMapper;
import com.example.bitirme.projesi.parkolay.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/parking-lot")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class ParkingLotController extends AbstractResponsePayload {
    private final ParkingLotService parkingLotService;
    private final ParkingSpaceDTOMapper parkingSpaceDTOMapper;
    private final ParkingLotDTOMapper mapper;

    @PostMapping(value = "/save")
    public ResponsePayload saveParkingSpace(@RequestBody ParkingLotDTO parkingLotDTO)
    {
        ParkingLot save = parkingLotService.saveParkingSpace(parkingLotDTO);
        if (save == null)
        {
            return getResponse(ResponseEnum.ERROR, "Kayıt işlemi başarısız!");
        }
        setResponseEnum(ResponseEnum.OK, "Başarılı.");
        return getResponse(save);
    }

    @GetMapping(value = "/list-all")
    public ResponsePayload listAll()
    {
        return getResponse(mapper.mapList(parkingLotService.listAll()));
    }

    @GetMapping(value = "/find-by-id")
    public ResponsePayload findParkingLot(@RequestParam("id") Long id) {
        Optional<ParkingLot> parkingLot = parkingLotService.findParkingLot(id);
        if (!parkingLot.isPresent())
        {
            return getResponse(ResponseEnum.ERROR, "Kayıt bulunamadı.");
        }
        return getResponse(mapper.map(parkingLot.get()));
    }

    @GetMapping(value = "list-all-parking-spaces-by-parking-lot-id")
    public ResponsePayload listAllParkingSpacesByParkingLotId(@RequestParam("parkingLotId") Long parkingLotId)
    {
        return getResponse(parkingLotService.listAllParkingSpacesByParkingLotId(parkingLotId));
    }

    @GetMapping(value = "/calculate-percentage-of-parkingLot")
    public ResponsePayload calculatePercentageOfParkingLot(@RequestParam("parkingLotId") Long parkingLotId)
    {
        String percentage = parkingLotService.calculatePercentage(parkingLotId);
        //return getResponse()
        return null;
    }


}
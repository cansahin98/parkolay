package com.example.bitirme.projesi.parkolay.service.impl;

import com.example.bitirme.projesi.parkolay.entity.LicensePlate;
import com.example.bitirme.projesi.parkolay.entity.ParkingHistory;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.mapper.ParkingHistoryDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.LicensePlateRepository;
import com.example.bitirme.projesi.parkolay.repo.ParkingHistoryRepository;
import com.example.bitirme.projesi.parkolay.service.ParkingHistoryService;
import com.example.bitirme.projesi.parkolay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingHistoryServiceImpl implements ParkingHistoryService {
    private final ParkingHistoryRepository repo;
    private final ParkingHistoryDTOMapper mapper;

    private final UserService userService;
    private final LicensePlateRepository licensePlateRepository;

    @Override
    public User findUserByLicensePlate(String licensePlate) {
        ParkingHistory parkingHistory = repo.findByLicensePlate_LicensePlateData(licensePlate);
        if (parkingHistory == null)
            return null;

        return parkingHistory.getUser();
    }

    @Override
    public ParkingHistory saveLicensePlate(Long userId, String licensePlate) {
        ParkingHistory parkingHistory = new ParkingHistory();
        Optional<User> user = userService.findUser(userId);
        parkingHistory.setUser(user.get());

        LicensePlate licensePlate1 = new LicensePlate();
        licensePlate1.setLicensePlateData(licensePlate);
        LicensePlate licensePlate2 = licensePlateRepository.save(licensePlate1);

        parkingHistory.setLicensePlate(licensePlate2);
        return repo.save(parkingHistory);
    }




    @Override
    public List<Object> checkIn(String licensePlate, Long userId) {
        Optional<User> user = userService.findUser(userId);
        if (user.get() == null)
        {
            return null;
        } else
        {

        }


        //List<Object> =
        return null;
    }
}

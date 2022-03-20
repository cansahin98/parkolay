package com.example.bitirme.projesi.parkolay.service.impl;


import com.example.bitirme.projesi.parkolay.dto.ParkingLotDTO;
import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.dto.UserSavedParkingLotDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.mapper.UserDTOMapper;
import com.example.bitirme.projesi.parkolay.mapper.UserSavedParkingLotDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.UserRepository;
import com.example.bitirme.projesi.parkolay.repo.UserSavedParkingLotRepository;
import com.example.bitirme.projesi.parkolay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserDTOMapper mapper;

    private final UserSavedParkingLotRepository userSavedParkingLotRepo;
    private final UserSavedParkingLotDTOMapper userSavedParkingLotDTOMapper;

    @Override
    public Optional<User> findUser(Long id)
    {
        return repo.findById(id);
    }

    @Override
    public User findUserByMail(String mail) {
        return repo.findByMail(mail);
    }


    @Override
    public User findUser(String mail, String password) {
        return repo.findByMailAndPassword(mail, password);
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        return repo.save(mapper.convertToEntity(userDTO));
    }

    @Override
    public User changePassword(Long id, String newPassword) {
        Optional<User> user = findUser(id);
        if (user != null)
        {
            user.get().setPassword(newPassword);
            return saveUser(mapper.map(user.get()));
        }
        return null;
    }

    @Override
    public List<ParkingLotDTO> findParkingLotByUserId(Long userId) {
        List<UserSavedParkingLotDTO> userSavedParkingLotList = userSavedParkingLotDTOMapper.mapList(userSavedParkingLotRepo.findAllByUser_Id(userId));
        List<ParkingLotDTO> parkingLotDTOList = new ArrayList<>();
        for (UserSavedParkingLotDTO userSavedParkingLotDTO : userSavedParkingLotList)
        {
            parkingLotDTOList.add(userSavedParkingLotDTO.getParkingLot());
        }

        return parkingLotDTOList;
    }
}

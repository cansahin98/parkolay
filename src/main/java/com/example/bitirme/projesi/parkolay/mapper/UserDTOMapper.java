package com.example.bitirme.projesi.parkolay.mapper;

import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDTOMapper {
    public UserDTO map(User user)
    {
        return UserDTO.Builder.UserWith()
                .id(user.getId())
                .mail(user.getMail())
                .password(user.getPassword())
                .name(user.getName())
                .isParked(user.isParked())
                .parkingLot(user.getParkingLot())
                .payment(user.getPayment())
                .build();
    }

    public List<UserDTO> mapList(List<User> userList)
    {
        List<UserDTO> mapList = new ArrayList<>();
        for (User user : userList)
        {
            mapList.add(this.map(user));
        }
        return mapList;
    }

    public User convertToEntity(UserDTO userDTO) {
        return UserDTO.Builder.UserWith().convertToEntity(userDTO);
    }

}

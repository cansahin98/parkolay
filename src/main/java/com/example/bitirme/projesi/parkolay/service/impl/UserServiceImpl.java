package com.example.bitirme.projesi.parkolay.service.impl;


import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.mapper.UserDTOMapper;
import com.example.bitirme.projesi.parkolay.repo.UserRepository;
import com.example.bitirme.projesi.parkolay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserDTOMapper mapper;

    @Override
    public User login(String mail, String password) {
        return repo.findByMailAndPassword(mail, password);
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        return repo.save(mapper.convertToEntity(userDTO));
    }
}

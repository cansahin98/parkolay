package com.example.bitirme.projesi.parkolay.service.impl;


import com.example.bitirme.projesi.parkolay.bean.User.FindUserBean;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayload;
import com.example.bitirme.projesi.parkolay.repo.UserRepository;
import com.example.bitirme.projesi.parkolay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final FindUserBean userBean;
    private final UserRepository repo;


    @Override
    public ResponsePayload login(String mail, String password) {

        return userBean.login(mail, password);

    }
}

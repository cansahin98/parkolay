package com.example.bitirme.projesi.parkolay.bean.User;

import com.example.bitirme.projesi.parkolay.dto.ResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindUserBean extends AbstractResponsePayload {

    //private final UserRepository repo;


    @Transactional
    public ResponsePayload login(String mail, String password) {
        //repo.findAll();
        return null;
    }
}

package com.example.bitirme.projesi.parkolay.controller;


import com.example.bitirme.projesi.parkolay.dto.ResponsePayload;
import com.example.bitirme.projesi.parkolay.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/login")
    public ResponsePayload login(@RequestParam("mail") String mail, @RequestParam("password") String password)
    {
        return userService.login(mail, password);
    }


}

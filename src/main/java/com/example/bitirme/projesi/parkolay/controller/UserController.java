package com.example.bitirme.projesi.parkolay.controller;


import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.enumeration.ResponseEnum;
import com.example.bitirme.projesi.parkolay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class UserController extends AbstractResponsePayload {
    private final UserService userService;
    //private final UserDTOMapper mapper;

    @PostMapping(value = "/login")
    public ResponsePayload login(@RequestParam("mail") String mail, @RequestParam("password") String password)
    {
        User user = userService.findUser(mail, password);
        if (user != null)
        {
            setResponseEnum(ResponseEnum.OK, "Kullanıcı bulundu");
            return getResponse(user);
        }
        return getResponse(ResponseEnum.NOTFOUND,"Kullanıcı bulunamadı!");
    }

    @PostMapping(value = "/register")
    public ResponsePayload register(@RequestBody UserDTO userDTO)
    {
        User user = userService.saveUser(userDTO);
        if (user.getId() != null)
        {
            return getResponse(ResponseEnum.OK, "Kayıt başarılı!");
        }
        return getResponse(ResponseEnum.WARNING,"Kayıt başarısız!!");
    }

    @PostMapping(value = "/change-password")
    public ResponsePayload changePassword(@RequestParam("mail") String mail, @RequestParam("password") String password,
                                          @RequestParam("new-password") String newPassword)
    {
        User user = userService.findUser(mail, password);
        if (user == null)
        {
            return getResponse(ResponseEnum.NOTFOUND,"Kullanıcı bulunamadı!");
        }
        Long userId = user.getId();

        User user1 = userService.changePassword(userId, mail, password, newPassword);
        if (user1 != null)
        {
            return getResponse(ResponseEnum.OK, "Şifre değiştirildi!");
        }
        return getResponse(ResponseEnum.WARNING,"Şifre Değiştirilemedi!!");
    }

}

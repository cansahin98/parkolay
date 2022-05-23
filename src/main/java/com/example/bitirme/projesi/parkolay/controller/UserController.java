package com.example.bitirme.projesi.parkolay.controller;


import com.example.bitirme.projesi.parkolay.dto.PaymentDTO;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.AbstractResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.ResponsePayloadDTO.ResponsePayload;
import com.example.bitirme.projesi.parkolay.dto.UserDTO;
import com.example.bitirme.projesi.parkolay.entity.ParkingHistory;
import com.example.bitirme.projesi.parkolay.entity.ParkingLot;
import com.example.bitirme.projesi.parkolay.entity.Payment;
import com.example.bitirme.projesi.parkolay.entity.User;
import com.example.bitirme.projesi.parkolay.enumeration.ResponseEnum;
import com.example.bitirme.projesi.parkolay.mapper.UserDTOMapper;
import com.example.bitirme.projesi.parkolay.service.ParkingHistoryService;
import com.example.bitirme.projesi.parkolay.service.ParkingLotService;
import com.example.bitirme.projesi.parkolay.service.PaymentService;
import com.example.bitirme.projesi.parkolay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//http://localhost:8080/user/login
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class UserController extends AbstractResponsePayload {
    private final UserService userService;
    private final UserDTOMapper mapper;

    private final PaymentService paymentService;
    private final ParkingHistoryService parkingHistoryService;

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

    @PostMapping(value = "/forgot-password")
    public ResponsePayload forgotPassword(@RequestParam("mail") String mail, @RequestParam("new-password") String newPassword)
    {
        User user = userService.findUserByMail(mail);
        if (user == null)
        {
            return getResponse(ResponseEnum.NOTFOUND,"Kullanıcı bulunamadı!");
        }
        //Long userId = user.getId();

        User user1 = userService.changePassword(user.getId(), newPassword);
        if (user1 != null)
        {
            return getResponse(ResponseEnum.OK, "Şifre değiştirildi!");
        }
        return getResponse(ResponseEnum.WARNING,"Şifre Değiştirilemedi!!");
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
        //Long userId = user.getId();

        User user1 = userService.changePassword(user.getId(), newPassword);
        if (user1 != null)
        {
            return getResponse(ResponseEnum.OK, "Şifre değiştirildi!");
        }
        return getResponse(ResponseEnum.WARNING,"Şifre Değiştirilemedi!!");
    }

    @GetMapping(value = "/find-saved-parking-lot")
    public ResponsePayload findParkingLotByUserId(@RequestParam Long userId)
    {
        return getResponse(userService.findParkingLotByUserId(userId));
    }

    @PostMapping(value = "/save-payment")
    public ResponsePayload savePayment(@RequestBody PaymentDTO paymentDTO,@RequestParam("userId") Long userId)
    {
        Optional<User> user = userService.findUser(userId);
        if (user.get() == null)
        {
            return getResponse(ResponseEnum.NOTFOUND,"Kullanıcı bulunamadı!");
        }
        Payment payment = paymentService.savePayment(paymentDTO);
        user.get().setPayment(payment);
        userService.saveUser(mapper.map(user.get()));
        return getResponse(user.get());
    }

    @GetMapping(value = "/find-payment-by-user-id")
    public ResponsePayload findAllPaymentsByUserId(@RequestParam("userId") Long userId)
    {
        Payment payment = userService.findPaymentByUserId(userId);
        if (payment == null){
            return getResponse(ResponseEnum.NOTFOUND, "Payment bulunamadı");
        }
        return getResponse(payment);
    }

    @PostMapping(value = "/save-license-plate")
    public ResponsePayload saveLicensePlate(@RequestParam("userId") Long userId, @RequestParam("license-plate") String licensePlate)
    {
        Optional<User> user = userService.findUser(userId);
        if (user.get() == null)
        {
            return getResponse(ResponseEnum.NOTFOUND, "Kullanıcı bulunamadı");
        }

        User user1 = parkingHistoryService.findUserByLicensePlate(licensePlate);
        if (user1 != null)
        {
            return getResponse(ResponseEnum.ERROR, "Bu plaka sistemde mevcut");
        }
        ParkingHistory parkingHistory = parkingHistoryService.saveLicensePlate(userId, licensePlate);


        return getResponse(parkingHistory);
    }


}

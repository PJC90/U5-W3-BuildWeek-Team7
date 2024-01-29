package buld.week.u5w4bw.controllers;

import buld.week.u5w4bw.entities.User;
import buld.week.u5w4bw.exceptions.BadRequestException;
import buld.week.u5w4bw.payloads.loginPayload.UserLoginDTO;
import buld.week.u5w4bw.payloads.loginPayload.UserLoginResponseDTO;
import buld.week.u5w4bw.payloads.userPayload.UserDTO;
import buld.week.u5w4bw.payloads.userPayload.UserResponseDTO;
import buld.week.u5w4bw.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO body){
        String accessToken = authService.authenticateUser(body);
        return new UserLoginResponseDTO(accessToken);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody @Validated UserDTO newUserPayload, BindingResult validation){
        if(validation.hasErrors()){
            System.out.println(validation.hasErrors());
            throw new BadRequestException(validation.getAllErrors());
        } else {
            User newUser = authService.save(newUserPayload);
            return new UserResponseDTO(newUser.getUserId());
        }
    }
}

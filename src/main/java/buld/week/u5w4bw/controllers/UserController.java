package buld.week.u5w4bw.controllers;

import buld.week.u5w4bw.entities.User;
import buld.week.u5w4bw.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<User> usersList(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size,@RequestParam(defaultValue ="userId")String order){
         return userService.findAll(page,size,order);
    }





}

package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/delete")
    public String deleteUser(){
        return "users/delete";
    }
    @PostMapping("/users/delete")
    public String delete(){
        return "redirect:/";
    }

    @GetMapping("/usermenu")
    public String userMenuPage(){
        return "users/usermenu";
    }

    @GetMapping("/aboutus")
    public String aboutUsPage(){return "users/menuhtml/aboutus";}

    @GetMapping("/accountbalance")
    public String accountBalancePage(){return "users/menuhtml/accountbalance";}

    @GetMapping("/contact")
    public String contactPage(){return "users/menuhtml/contact";}

    @GetMapping("/history")
    public String historyPage(){return "users/menuhtml/history";}

    @GetMapping("/rental")
    public String rentalPage(){return "users/menuhtml/rental";}

    @GetMapping("/topupaccount")
    public String topUpAccountPage(){return "users/menuhtml/topupaccount";}

}

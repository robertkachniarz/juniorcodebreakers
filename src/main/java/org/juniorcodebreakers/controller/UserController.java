package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.login.BikeUserRepository;
import org.juniorcodebreakers.login.Role;
import org.juniorcodebreakers.model.user.BikeUser;
import org.juniorcodebreakers.model.user.BikeUserForm;
import org.juniorcodebreakers.service.BikeUserApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UserController {
    private final BikeUserApiClient client;
    private final BikeUserRepository repository;

    @Autowired
    public UserController(BikeUserApiClient client, BikeUserRepository repository) {
        this.client = client;
        this.repository = repository;
    }
    @GetMapping("/users/add")
    public String addUser(){
        return "users/add";
    }

    @PostMapping("/users/add")
    public String add(@ModelAttribute BikeUserForm bikeUserForm, RedirectAttributes redirectAttributes){
        BikeUser bikeUser = new BikeUser();
        bikeUser.setLogin(bikeUserForm.getLogin());
        bikeUser.setPassword(bikeUserForm.getPassword());
        bikeUser.setE_mail(bikeUserForm.getE_mail());
        bikeUser.setRole(Role.USER.toString());
        repository.save(bikeUser);
        redirectAttributes.addFlashAttribute("result", "Użytkownik został dodany");
        return "redirect:/usermenu";
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

    @GetMapping("/users/{login}")
    public String myAccoutnPage(@PathVariable String login, Model model){
        model.addAttribute("bikeuser", repository.findByLogin(login).get());
        return "users/menuhtml/myaccount";}

    @GetMapping("/rental")
    public String rentalPage(){return "users/menuhtml/rental";}

    @GetMapping("/topupaccount")
    public String topUpAccountPage(){return "users/menuhtml/topupaccount";}

    @GetMapping("/home")
    public String homePage(){
        return "users/home";
    }
}

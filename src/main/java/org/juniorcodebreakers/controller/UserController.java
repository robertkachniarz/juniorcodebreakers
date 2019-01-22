package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.login.BikeUserRepository;
import org.juniorcodebreakers.login.Role;
import org.juniorcodebreakers.login.RoleRepository;
import org.juniorcodebreakers.model.user.BikeUser;
import org.juniorcodebreakers.model.user.BikeUserForm;
import org.juniorcodebreakers.service.BikeUserApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.google.common.collect.Sets;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping
public class UserController {
    private final BikeUserApiClient client;
    private final BikeUserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public UserController(BikeUserApiClient client, BikeUserRepository repository) {
        this.client = client;
        this.repository = repository;
    }
    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/users/add")
    public String addUser(){
        return "users/add";
    }

    @PostMapping("/users/add")
    public String add(@ModelAttribute BikeUserForm bikeUserForm, RedirectAttributes redirectAttributes){
        BikeUser bikeUser = new BikeUser();
        bikeUser.setLogin(bikeUserForm.getLogin());
        bikeUser.setPassword(passwordEncoder.encode(bikeUserForm.getPassword()));
        bikeUser.setE_mail(bikeUserForm.getE_mail());
        Role userRole = roleRepository.save(new Role("USER"));
        bikeUser.setRoles(Sets.newHashSet(userRole));
        repository.save(bikeUser);
        redirectAttributes.addFlashAttribute("result", "Użytkownik został dodany");
        return "redirect:/login";
    }

    @GetMapping("/users/delete")
    public String deleteUser(){
        return "users/delete";
    }
    @PostMapping("/users/delete")
    public String delete(Principal principal){
        Optional<BikeUser> bikeUser = repository.findByLogin(principal.getName());
        repository.delete(bikeUser.get());
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

    @GetMapping("/myaccount")
    public String myAccoutnPage(Principal principal, Model model){
        Optional<BikeUser> bikeUser = repository.findByLogin(principal.getName());
        model.addAttribute("bikeuser", bikeUser.get());
        return "users/menuhtml/myaccount";}

    @GetMapping("/rental")
    public String rentalPage(){return "users/menuhtml/rental";}

    @GetMapping("/topupaccount")
    public String topUpAccountPage(){return "users/menuhtml/topupaccount";}

    @GetMapping("/homepage")
    public String homePage(){
        return "users/homepage";
    }
}

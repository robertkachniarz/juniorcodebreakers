package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.login.BikeUserRepository;
import org.juniorcodebreakers.login.Role;
import org.juniorcodebreakers.model.user.BikeUser;
import org.juniorcodebreakers.model.user.BikeUserForm;
import org.juniorcodebreakers.service.BikeUserApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        bikeUser.setRole(Role.USER.toString());
        repository.save(bikeUser);
        redirectAttributes.addFlashAttribute("result", "Użytkownik został dodany");
        return "redirect:/usermenu";
    }

    @GetMapping("/about")
    public String aboutUser(){
        return "users/about";
    }

    @GetMapping("/usermenu")
    public String userMenu(){
        return "users/usermenu";
    }

    @GetMapping("/home")
    public String homePage(){
        return "users/home";
    }
}

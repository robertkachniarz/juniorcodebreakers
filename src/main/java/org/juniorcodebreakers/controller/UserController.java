package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.login.BikeUserRepository;
import org.juniorcodebreakers.model.user.BikeUser;
import org.juniorcodebreakers.model.user.BikeUserForm;
import org.juniorcodebreakers.service.BikeUserApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/signup")
    public String add(@ModelAttribute BikeUserForm bikeUserForm){
        BikeUser bikeUser = new BikeUser();
        bikeUser.setLogin(bikeUserForm.getLogin());
        bikeUser.setPassword(bikeUserForm.getPassword());
        repository.save(bikeUser);
        return "/h2";
    }
}

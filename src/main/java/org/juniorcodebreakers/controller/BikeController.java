package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.model.Bike;
import org.juniorcodebreakers.model.Status;
import org.juniorcodebreakers.service.bike.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BikeController {
    @Autowired
    public BikeRepository bikeRepository;

    @RequestMapping("/bikes")
    @ResponseBody
    public String testMethod(){
        StringBuilder response = new StringBuilder();

        Bike bike = new Bike(Status.STOLEN);
        bikeRepository.save(bike);

        for (Bike bike1: bikeRepository.findAll()){
            response.append(bike1).append("<br>");
        }
        return response.toString();
    }
}

package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.model.Bike;
import org.juniorcodebreakers.model.Status;
import org.juniorcodebreakers.service.bike.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping
public class BikeController {
    @Autowired
    public BikeRepository bikeRepository;

    @GetMapping("/bike")
    public String addPage() {
        return "bike";
    }

    @PostMapping("/bike")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBike(@ModelAttribute  RedirectAttributes redirectAttributes) {
        bikeRepository.save(new Bike(Status.READY_TO_DISTRIBUTION));
        redirectAttributes.addFlashAttribute("result", "Rower został dodany");
        return "redirect:/bike";
    }

    @DeleteMapping("/bikes/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBike(long bikeId) {
        bikeRepository.deleteById(bikeId);
        return ("/bikes");
    }

    @PutMapping("bikes/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateBikeStatus(long bikeId, Status status) {
        Bike bike = bikeRepository.findById(bikeId).get();
        bike.setStatus(status);
        bikeRepository.save(bike);
        return "/bikes/update";
    }

    @GetMapping("/bikes/findbyid")
    @ResponseStatus(HttpStatus.OK)
    public String findById(long id) {
         bikeRepository.findById(id).get();
        return "/bikes/findbyid";
    }

    @GetMapping("/bikes/findall")
    @ResponseStatus(HttpStatus.OK)
    public String findAllBikes() {
        bikeRepository.findAll();
        /* StreamSupport.stream(bikeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());*/
         return "/bikes/findall";
    }


}

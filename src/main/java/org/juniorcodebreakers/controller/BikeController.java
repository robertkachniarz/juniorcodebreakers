package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.model.Bike;
import org.juniorcodebreakers.model.Status;
import org.juniorcodebreakers.service.bike.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping
public class BikeController {
    @Autowired
    public BikeRepository bikeRepository;

    @GetMapping("/bikes/add")
    public String addPage() {
        return "bikes/addbike";
    }

    @PostMapping("/bikes/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBike() {
        bikeRepository.save(new Bike(Status.READY_TO_DISTRIBUTION));
        return "bikes/bikes";
    }

    @GetMapping("/bikes")
    @ResponseStatus(HttpStatus.OK)
    public String bikesPage(){
        return "bikes/bikes";
    }

    @DeleteMapping("/bikes/delete/{bikeId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBike(@PathVariable Long bikeId,RedirectAttributes redirectAttributes) {
        bikeRepository.deleteById(bikeId);
        redirectAttributes.addFlashAttribute("result", ("Rower o numerze: " +bikeId+" został usunięty pomyślnie"));
        return "redirect:/bikes/bikes";
    }

    @PostMapping("/bikes/update/{bikeId}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public String updateBikeStatus(
            @PathVariable Long bikeId,
            @PathVariable String status,
           RedirectAttributes redirectAttributes){
        Bike bike =bikeRepository.findById(bikeId).get();
        bike.setStatus(Status.valueOf(status));
        bikeRepository.save(bike);
        redirectAttributes.addFlashAttribute("result", ("Zmieniono status roweru o numerze: " +bikeId+" na status: "+status+"."));
        return "redirect:/bikes/bikes";
    }

    @GetMapping(value = "/bikes/findbyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("bike",bikeRepository.findById(id).get());
        return"bikes/bikes";
    }

    @GetMapping("/bikes/findall")
    @ResponseStatus(HttpStatus.OK)
    public String findAllBikes(Model model){
        model.addAttribute("bikesList",StreamSupport.stream(bikeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()));
        return "bikes/bikes";
    }


    @GetMapping("/test")
    public String test(){return "bikes/test";}







}

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

    @GetMapping("/bikes/delete/{bikeId}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePage(Model model, @PathVariable Long bikeId){
        model.addAttribute("bikeId", bikeRepository.findById(bikeId));
        return "bikes/bikes";
    }

    @PostMapping("/bikes/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBike(Model model, @RequestParam("id") Long id) {
       model.addAttribute("id",id);
       bikeRepository.deleteById(id);
        return "bikes/bikes";
    }
  /*  @GetMapping("/books/{bookId}")
    public String details(Model model, @PathVariable String bookId) {
        model.addAttribute("book", client.fetchBookInfo(bookId));
        return "books/details";

    }*/

    @PostMapping("/bikes/update/{id}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public String updateBikeStatus(
            Model model,
            @RequestParam("id") Long id,
            @RequestParam("status") String status){
        model.addAttribute("id",id);
        model.addAttribute("status",status);
        Bike bike =bikeRepository.findById(id).get();
        bike.setStatus(Status.valueOf(status));
        bikeRepository.save(bike);
        return "bikes/bikes";
    }

    @GetMapping(value = "/bikes/findbyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("bike",bikeRepository.findById(id).get());
        return"bikes/bikes";
    }

    @GetMapping("/bikes")
    @ResponseStatus(HttpStatus.OK)
    public String findAllBikes(Model model){
        model.addAttribute("bikesList",StreamSupport.stream(bikeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()));
        return "bikes/bikes";
    }


    @GetMapping("/admin")
    public String adminPage(){return "bikes/admin";}

    @GetMapping("/stations")
    public String stationsPage(){return "bikes/stations";}







}

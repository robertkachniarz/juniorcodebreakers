package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.Main;
import org.juniorcodebreakers.model.Bike;
import org.juniorcodebreakers.model.Status;
import org.juniorcodebreakers.service.bike.BikeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Optional;
import static org.juniorcodebreakers.model.Status.STOLEN;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BikeController.class)
@ContextConfiguration(classes={Main.class})
public class BikeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BikeRepository bikeRepository;

    @Test
    public void shouldFindAllBikes() throws Exception {
        // given
       Bike first = new Bike(1L,Status.STOLEN);
       Bike second= new Bike(2L,Status.IN_REPAIR);
       given(bikeRepository.findAll()).willReturn(Arrays.asList(first, second));
        // when
        mockMvc.perform(get("/bikes/findall"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML+";charset=UTF-8"))
                .andExpect(view().name("bikes/bikes"));
    }

    @Test
    public void shouldAddBike() throws Exception {
        // given
        Bike first = new Bike(Status.READY_TO_DISTRIBUTION);
        given(bikeRepository.save(first)).willReturn(first);
        // when
        mockMvc.perform(post("/bikes/add"))
         // then
                .andExpect(status().isCreated());
        then(bikeRepository).should().save(first);
    }

    @Test
    public void shouldFindBikeById() throws Exception {
        // given
        Bike first = new Bike(1L, Status.STOLEN);
        Optional<Bike> optionalBike = Optional.of(first);
        given(bikeRepository.findById(1L)).willReturn(optionalBike);
        // when
        mockMvc.perform(get("/bikes/findbyid/1"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML+";charset=UTF-8"))
                .andExpect(view().name("bikes/details"));
    }
    @Test
    public void shouldDeleteBikeById() throws Exception {
        // given
        Bike first = new Bike(1L, Status.STOLEN);
        Bike second= new Bike(2L,Status.IN_REPAIR);
        // when
        mockMvc.perform(delete("/bikes/delete/1"))
                // then
                .andExpect(status().isOk());
        then(bikeRepository).should().deleteById(first.getId());
    }

    @Test
    public void shouldUpdateBikeStatus() throws Exception {
        // given
       Bike updatedBike = new Bike(1L, Status.STOLEN);
        given(bikeRepository.findById(1L)).willReturn(Optional.of(updatedBike));
        updatedBike.setStatus(STOLEN);
        // when
        mockMvc.perform(post("/bikes/update/1/STOLEN"))
                // then
               .andExpect(status().isOk());
        then(bikeRepository).should().save(updatedBike);
    }




}



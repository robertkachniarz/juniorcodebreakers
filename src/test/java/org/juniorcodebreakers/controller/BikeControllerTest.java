package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.Main;
import org.juniorcodebreakers.model.Bike;
import org.juniorcodebreakers.model.Status;
import org.juniorcodebreakers.service.bike.BikeRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BikeController.class)
@ContextConfiguration(classes={Main.class})
public class BikeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BikeRepository bikeRepository;

    private Bike first = new Bike(1l,Status.STOLEN);
    private Bike second= new Bike(2l,Status.IN_REPAIR);


    @Test
    public void shouldFindAllBikes() throws Exception {
        // given
        given(this.bikeRepository.findAll()).willReturn(Arrays.asList(first, second));
        // when
        mockMvc.perform(get("/bikes/findall"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string("[{\"id\":1,\"status\":\"STOLEN\"},{\"id\":2,\"status\":\"IN_REPAIR\"}]"));
    }

    @Test
    public void shouldAddBike() throws Exception {
        // given
        given(this.bikeRepository.findAll()).willReturn(Arrays.asList(first, second));
        // when
        mockMvc.perform(get("/bikes/findall"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string("[{\"id\":1,\"status\":\"STOLEN\"},{\"id\":2,\"status\":\"IN_REPAIR\"}]"));
    }


}



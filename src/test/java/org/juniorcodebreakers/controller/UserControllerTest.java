package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.Main;
import org.juniorcodebreakers.login.BikeUserRepository;
import org.juniorcodebreakers.login.Role;
import org.juniorcodebreakers.model.user.BikeUser;
import org.juniorcodebreakers.service.BikeUserApiClientImpl;
import org.juniorcodebreakers.service.bike.BikeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes={Main.class})
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BikeUserApiClientImpl bikeUserApiClient;
    @MockBean
    private BikeUserRepository bikeUserRepository;

    @Test
    void shouldShowAddUser() throws Exception {
        // given
        // when
        mockMvc.perform(get("/users/add"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/add"));
    }

    @Test
    void shouldAdd() throws Exception {
        // given
        BikeUser bikeUser = new BikeUser();
        bikeUser.setRole(Role.USER.toString());
       given(bikeUserRepository.save(bikeUser)).willReturn(bikeUser);
        // when
        mockMvc.perform(post("/users/add"))
        //then
               .andExpect(status().isCreated());
        then(bikeUserRepository).should().save(bikeUser);
    }

    @Test
    void shouldShowUserMenuPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/usermenu"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/usermenu"));
    }

    @Test
    void shouldShowAboutUsPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/aboutus"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/aboutus"));
    }

    @Test
    void shouldShowAccountBalancePage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/accountbalance"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/accountbalance"));
    }

    @Test
    void shouldShowContactPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/contact"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/contact"));
    }

    @Test
    void shouldShowHistoryPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/history"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/history"));
    }

    @Test
    void shouldShowMyAccoutnPage() throws Exception {
        // given
        BikeUser bikeUser = new BikeUser();
        bikeUser.setLogin("login");
        bikeUser.setRole(Role.USER.toString());
        given(bikeUserRepository.findByLogin("login")).willReturn(Optional.of(bikeUser));
        // when
        mockMvc.perform(get("/users/login"))
                // then
                .andExpect(status().isOk())
                .andExpect(model().attribute("bikeuser",bikeUser))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/myaccount"));
    }

    @Test
    void shouldShowRentalPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/rental"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/rental"));
    }

    @Test
    void shouldShowTopUpAccountPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/users/login"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/topupaccount"));
    }

    @Test
    void shouldShowHomePage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/home"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"))
                .andExpect(view().name("users/home"));
    }

}
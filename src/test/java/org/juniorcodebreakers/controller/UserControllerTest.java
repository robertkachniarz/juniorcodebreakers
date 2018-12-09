package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.Main;
import org.juniorcodebreakers.login.BikeUserRepository;
import org.juniorcodebreakers.login.Role;
import org.juniorcodebreakers.model.user.BikeUser;
import org.juniorcodebreakers.service.BikeUserApiClient;
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

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {Main.class})
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BikeUserRepository bikeUserRepository;
    @MockBean
    private BikeUserApiClient bikeUserApiClient;

    @Test
    public void shouldShowAddUser() throws Exception {
        // given
        // when
        mockMvc.perform(get("/users/add"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/add"));
    }

    @Test
    public void shouldAdd() throws Exception {
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
    public void shouldShowUserMenuPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/usermenu"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/usermenu"));
    }

    @Test
    public void shouldShowAboutUsPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/aboutus"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/aboutus"));
    }

    @Test
    public void shouldShowAccountBalancePage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/accountbalance"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/accountbalance"));
    }

    @Test
    public void shouldShowContactPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/contact"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/contact"));
    }

    @Test
    public void shouldShowHistoryPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/history"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/history"));
    }

    @Test
    public void shouldShowMyAccoutnPage() throws Exception {
        // given
        BikeUser bikeUser = new BikeUser();
        bikeUser.setLogin("login");
        bikeUser.setRole(Role.USER.toString());
        given(bikeUserRepository.findByLogin("login")).willReturn(Optional.of(bikeUser));
        // when
        mockMvc.perform(get("/users/login"))
                // then
                .andExpect(status().isOk())
                .andExpect(model().attribute("bikeuser", bikeUser))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/myaccount"));
    }

    @Test
    public void shouldShowRentalPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/rental"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/rental"));
    }

    @Test
    public void shouldShowTopUpAccountPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/topupaccount"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/menuhtml/topupaccount"));
    }

    @Test
    public void shouldShowHomePage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/home"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(view().name("users/home"));
    }

}
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

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void shouldAddUser() throws Exception {
        // given
        // when
        mockMvc.perform(get("/users/add"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
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
               .andExpect(status().isFound());
        then(bikeUserRepository).should().save(bikeUser);
    }

    @Test
    void userMenuPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/usermenu"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void aboutUsPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/aboutus"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void accountBalancePage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/accountbalance"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void contactPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/contact"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void historyPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/history"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void myAccoutnPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/myaccount"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void rentalPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/rental"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void topUpAccountPage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/topupaccount"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }

    @Test
    void homePage() throws Exception {
        // given
        // when
        mockMvc.perform(get("/home"))
                // then
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
        // .andExpect(content().);
    }
}
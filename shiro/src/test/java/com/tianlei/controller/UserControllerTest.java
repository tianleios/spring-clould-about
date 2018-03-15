package com.tianlei.controller;


import com.tianlei.ShiroApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShiroApplication.class})
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .param("userName","tianlei")
                .param("password","password");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("success"));

    }

    @Test
    public void adminOnly() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("admin"));

    }
}

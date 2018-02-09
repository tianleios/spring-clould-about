package com.tl.controller;

import javafx.beans.binding.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() {
       this.mockMvc.perform(get("/"))
    }

}

package com.tl.controller;

import com.tl.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// 解决 测试 加载问题
// https://stackoverflow.com/questions/43515279/error-unable-to-find-springbootconfiguration-when-doing-webmvctest-for-spring/43517967
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}) //指定测试的应用
@AutoConfigureMockMvc
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {


        get("/test/get");



        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders
                        .get("/test/get")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();

        int statusCode = mvcResult.getResponse().getStatus();
        Assert.assertEquals(statusCode, 200);

        String body = mvcResult.getResponse().getContentAsString();
        System.out.println("body:" + body);
//        Assert.assertEquals(body,"success");

    }

    @Test
    public void testPost() throws Exception {

        //  status()  content() 属于静态导入， import static
        RequestBuilder requestBuilder = post("/test/post")
                .param("name","tianlei");
        mockMvc.perform( requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ \"name\" : \"tianlei\"}"));


    }
}
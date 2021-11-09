package com.lance.mybatisplus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @program: mybatisplus  TestController
 * @description:
 * @author: flchen
 * @create: 2021-11-09 18:44
 **/

@AutoConfigureMockMvc
@SpringBootTest
public class TestController {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testMvc() throws Exception {
        System.out.println(mockMvc.perform(get("/demo/test")).andReturn().getResponse().getContentAsString());
    }


}

package com.techreturners.myspringdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTests {
    @Autowired
    private MockMvc mockMvcController;
    @Test
    public void testCoffeeLover() throws Exception{
        String expectedContent = "I like coffee!";
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
    @Test
    public void testGetCoffeeWithoutRequestParameter() throws Exception {
        String expectedValue = "latte";
                this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));

    }
    @Test
    public void testGetCoffeeWithRequestParameter() throws Exception {
        String expectedValue = "cappuccino";
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffee").param("name",expectedValue))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));

    }

}

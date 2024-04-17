package com.jdd.esource_demo_project.controller;

import com.jdd.esource_demo_project.service.EsourceDemoService;
import com.jdd.esource_demo_project.service.RandomNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class EsourceDemoControllerTests {

    private EsourceDemoController subject;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RandomNumberService randomNumberService;

    @MockBean
    private EsourceDemoService esourceDemoService;

    @BeforeEach
    public void setUp() {
        subject = new EsourceDemoController(randomNumberService, esourceDemoService);
    }

    @Test
    public void contextLoads() {}

    @Test
    public void runEsourceDemoTest() throws Exception {
        Integer[][] mockRandomNumbers = new Integer[][]{
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
                {26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 11, 12, 13, 14, 15}
        };
        Integer[] mockAvailableNumbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Mockito.when(randomNumberService.generateRandomNumbers()).thenReturn(mockRandomNumbers);
        Mockito.when(esourceDemoService.availableNumbers(mockRandomNumbers)).thenReturn(mockAvailableNumbers);
        Mockito.when(esourceDemoService.largestPrimeNumber(mockAvailableNumbers)).thenReturn(7);
        mockMvc.perform(MockMvcRequestBuilders.get("/run"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

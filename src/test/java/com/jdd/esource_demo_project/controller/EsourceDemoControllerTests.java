package com.jdd.esource_demo_project.controller;

import com.jdd.esource_demo_project.service.EsourceDemoService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EsourceDemoService esourceDemoService;

    @BeforeEach
    public void setUp() {
        subject = new EsourceDemoController(esourceDemoService);
    }

    @Test
    public void contextLoads() {}

    @Test
    public void runEsourceDemoTest() throws Exception {
        Number[] mockValues = new Number[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Mockito.when(esourceDemoService.availableNumbers()).thenReturn(mockValues);
        Mockito.when(esourceDemoService.largestPrimeNumber(mockValues)).thenReturn(new Number[]{7});
        mockMvc.perform(MockMvcRequestBuilders.get("/run"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

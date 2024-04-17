package com.jdd.esource_demo_project.controller;

import com.jdd.esource_demo_project.service.EsourceDemoService;
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
    private EsourceDemoService esourceDemoService;

    @BeforeEach
    public void setUp() {
        subject = new EsourceDemoController(esourceDemoService);
    }

    @Test
    public void contextLoads() {}

    @Test
    public void userStoryOneTest() throws Exception {
        Number[] mockValues = new Number[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Mockito.when(esourceDemoService.availableNumbers()).thenReturn(mockValues);
        mockMvc.perform(MockMvcRequestBuilders.get("/one"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

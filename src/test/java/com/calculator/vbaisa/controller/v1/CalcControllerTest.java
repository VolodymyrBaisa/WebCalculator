package com.calculator.vbaisa.controller.v1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalcController.class)
public class CalcControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CalcController calcControllerMock;

    @BeforeEach
    public void setup(){}

    @Test
    public void testHappyPath() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/v1/calculate/{exp}", 20)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("20"));
    }
    @Test
    public void testInvalidRequest() throws Exception {
      mvc.perform(MockMvcRequestBuilders
                .get("/v1/calculate1/{exp}", 20)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

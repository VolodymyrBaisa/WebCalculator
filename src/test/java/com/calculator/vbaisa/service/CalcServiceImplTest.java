package com.calculator.vbaisa.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalcServiceImplTest {
    private static final String CALCULATION_ERROR = "Calculation error";

    @Autowired
    private CalcService calcService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldReturnCorrectValue() {
        String val = calcService.CalculateValue("20+20");
        assertEquals("40", val);
    }

    @Test
    public void testCaseExpIsNull() {
        String val = calcService.CalculateValue(null);
        assertEquals("", val);
    }

    @Test
    public void testCaseExpIsEmpty() {
        String val = calcService.CalculateValue("");
        assertEquals("", val);
    }

    @Test
    public void testCaseExpIsIncorrect() {
        String val = calcService.CalculateValue("20+");
        assertEquals(CALCULATION_ERROR, val);
    }
}

package com.calc.calculation.controller;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.calc.calculation.CalculationApplication;
import com.calc.calculation.dto.CalculationResponse;
import com.calc.calculation.dto.OperationRequest;
import com.calc.calculation.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculationApplication.class)
public class CalcControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private WebApplicationContext context;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).alwaysDo(print()).build();
    }

    @SneakyThrows
    @Test
    public void calculateAdditionValuesFromFile() {
        String requestName = "requests/request_for_addition.json";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(checkNotNull(classLoader.getResource(requestName)).getFile());
        OperationRequest operationRequest = objectMapper.readValue(file, OperationRequest.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/calc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(operationRequest)))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        CalculationResponse calculationResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), CalculationResponse.class);
        Assert.assertEquals(15, calculationResponse.getResult());
    }

    @SneakyThrows
    @Test
    public void calculateMultiplicationValuesFromFile() {
        String requestName = "requests/request_for_multiplication.json";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(checkNotNull(classLoader.getResource(requestName)).getFile());
        OperationRequest operationRequest = objectMapper.readValue(file, OperationRequest.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/calc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(operationRequest)))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        CalculationResponse calculationResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), CalculationResponse.class);
        Assert.assertEquals(50, calculationResponse.getResult());
    }

    @SneakyThrows
    @Test
    public void calculateDivisionValuesFromFile() {
        String requestName = "requests/request_for_division.json";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(checkNotNull(classLoader.getResource(requestName)).getFile());
        OperationRequest operationRequest = objectMapper.readValue(file, OperationRequest.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/calc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(operationRequest)))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        CalculationResponse calculationResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), CalculationResponse.class);
        Assert.assertEquals(2, calculationResponse.getResult());
    }

    @SneakyThrows
    @Test
    public void calculateSubtractionValuesFromFile() {
        String requestName = "requests/request_for_subtraction.json";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(checkNotNull(classLoader.getResource(requestName)).getFile());
        OperationRequest operationRequest = objectMapper.readValue(file, OperationRequest.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/calc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(operationRequest)))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        CalculationResponse calculationResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), CalculationResponse.class);
        Assert.assertEquals(5, calculationResponse.getResult());
    }

}
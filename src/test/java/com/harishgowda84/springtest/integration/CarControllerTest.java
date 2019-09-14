package com.harishgowda84.springtest.integration;

import com.harishgowda84.springtest.domain.Car;
import com.harishgowda84.springtest.exceptions.CarNotFoundException;
import com.harishgowda84.springtest.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar() throws Exception {

        given(carService.getDetails(anyString())).willReturn(new Car("tesla","hybrid"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/tesla"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("tesla"));

    }

    @Test
    public void getCarNotFound() throws Exception {

        given(carService.getDetails(anyString())).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/tesla"))
                .andExpect(status().isNotFound());

    }
}

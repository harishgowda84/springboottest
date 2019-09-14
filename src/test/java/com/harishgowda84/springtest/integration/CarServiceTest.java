package com.harishgowda84.springtest.integration;

import com.harishgowda84.springtest.domain.Car;
import com.harishgowda84.springtest.exceptions.CarNotFoundException;
import com.harishgowda84.springtest.repository.CarRepository;
import com.harishgowda84.springtest.service.CarService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws Exception {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarServiceTest(){

        given(carRepository.findByName(anyString())).willReturn(new Car("tesla","hybrid"));

        Car car = carService.getDetails("tesla");

        Assertions.assertThat(car.getName()).isEqualTo("tesla");


    }

    @Test(expected = CarNotFoundException.class)
    public void getCarNotFoundException(){

        given(carRepository.findByName(anyString())).willReturn(null);
        Car car = carService.getDetails("tesla");
    }
}

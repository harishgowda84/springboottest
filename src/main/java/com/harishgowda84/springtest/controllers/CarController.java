package com.harishgowda84.springtest.controllers;

import com.harishgowda84.springtest.domain.Car;
import com.harishgowda84.springtest.exceptions.CarNotFoundException;
import com.harishgowda84.springtest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.CardNotPresentException;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{carName}")
    public Car getCars(@PathVariable String carName){
        return carService.getDetails("tesla");
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundException(CarNotFoundException ex)
    {}
}

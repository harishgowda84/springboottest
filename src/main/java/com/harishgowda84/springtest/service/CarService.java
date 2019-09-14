package com.harishgowda84.springtest.service;

import com.harishgowda84.springtest.domain.Car;
import com.harishgowda84.springtest.exceptions.CarNotFoundException;
import com.harishgowda84.springtest.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository=carRepository;
    }

    public Car getDetails(String carName) {

        Car car = carRepository.findByName(carName);
        if(car != null){
            return car;
        }else{
            throw new CarNotFoundException();
        }
    }
}

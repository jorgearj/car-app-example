package com.exercise.carapp.service;

import com.exercise.carapp.model.Car;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    public CarService() {
    }

    public List<Car> getCars(){
        return new ArrayList<>();
    }

    public Car getCar(Long id){
        return Car.builder()
                .id(id)
                .marca("Hyundai")
                .modelo("I30")
                .matricula("11-AA-22")
                .consumoCombinado(new BigDecimal(6.9))
                .build();
    }
}

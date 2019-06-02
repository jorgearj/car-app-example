package com.exercise.carapp.service;

import com.exercise.carapp.exception.CarNotFoundException;
import com.exercise.carapp.model.Car;
import com.exercise.carapp.model.Coordinate;
import com.exercise.carapp.model.Route;
import com.exercise.carapp.repository.CarsRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarsRepository carsRepository;
    private RoutesService routesService;

    public CarService(CarsRepository carsRepository, RoutesService routesService) {
        this.carsRepository = carsRepository;
        this.routesService = routesService;
    }

    public List<Car> getCars(){
        return Lists.newArrayList(carsRepository.findAll());
    }

    public Car getCar(Long id){
        Optional<Car> carResult = carsRepository.findById(id);

        if(!carResult.isPresent()){
            throw new CarNotFoundException("The car cannot be deleted since it does not exist");
        }

        return carResult.get();
    }

    public Car addCar(Car car){
        return carsRepository.save(car);
    }

    public Long removeCar(Long id){
        Car car = this.getCar(id);

        carsRepository.delete(car);

        return id;
    }

    public Route getCarRoute(Long id, String start, String end){
        Car car = this.getCar(id);

        Coordinate startingPoint = this.routesService.getGeoLocation(start);
        Coordinate endingPoint = this.routesService.getGeoLocation(end);



        return this.routesService.calculateRoute(startingPoint, endingPoint, car);
    }
}

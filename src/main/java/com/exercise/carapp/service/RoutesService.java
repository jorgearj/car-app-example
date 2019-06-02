package com.exercise.carapp.service;

import com.exercise.carapp.model.Car;
import com.exercise.carapp.model.Coordinate;
import com.exercise.carapp.model.Route;
import org.springframework.stereotype.Component;

@Component
public interface RoutesService {

    Coordinate getGeoLocation(String address);
    Route calculateRoute(Coordinate start, Coordinate end, Car car);
}

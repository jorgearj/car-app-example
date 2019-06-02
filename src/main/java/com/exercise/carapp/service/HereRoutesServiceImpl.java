package com.exercise.carapp.service;

import com.exercise.carapp.model.Car;
import com.exercise.carapp.model.Coordinate;
import com.exercise.carapp.model.Route;
import org.springframework.stereotype.Service;

@Service
public class HereRoutesServiceImpl implements RoutesService {

    @Override
    public Coordinate getGeoLocation(String address) {
        //TODO: call HERE API for geoLocation mapping
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Route calculateRoute(Coordinate start, Coordinate end, Car car) {
        //TODO: call HERE API for route calculation
        //TODO: need to calculate fuel consumption based on distance and car comsumption
        throw new RuntimeException("Not yet implemented");
    }
}

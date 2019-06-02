package com.exercise.carapp.repository;

import com.exercise.carapp.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository <Car, Long>{

}

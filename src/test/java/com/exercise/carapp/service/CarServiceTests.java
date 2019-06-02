package com.exercise.carapp.service;

import com.exercise.carapp.exception.CarNotFoundException;
import com.exercise.carapp.model.Car;
import com.exercise.carapp.repository.CarsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CarServiceTests {

    private CarService service;

    @Mock
    private CarsRepository carsRepository;
    @Mock
    private RoutesService routesService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.service = new CarService(carsRepository, routesService);
    }

    @Test
    public void getCars(){

        when(this.carsRepository.findAll()).thenReturn(mockCars(3));
        List<Car> cars = service.getCars();
        assertEquals(3, cars.size());
    }

    @Test
    public void getEmptyCars(){

        when(this.carsRepository.findAll()).thenReturn(mockCars(0));
        List<Car> cars = service.getCars();
        assertEquals(0, cars.size());
    }

    @Test(expected = CarNotFoundException.class)
    public void getCar(){
        Long id = 12345L;
        Optional<Car> optional = Optional.empty();
        when(this.carsRepository.findById(id)).thenReturn(optional);
        service.getCar(id);
    }

    @Test(expected = CarNotFoundException.class)
    public void deleteCarNotExist(){
        Long id = 12345L;
        Optional<Car> optional = Optional.empty();
        when(this.carsRepository.findById(id)).thenReturn(optional);
        service.removeCar(id);
    }

    private List<Car> mockCars(int count){
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i< count; i++){
            cars.add(Car.builder()
                    .id(new Long(i))
                    .marca("marca"+i)
                    .build());
        }

        return cars;
    }

}

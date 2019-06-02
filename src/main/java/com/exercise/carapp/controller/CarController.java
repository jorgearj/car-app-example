package com.exercise.carapp.controller;

import com.exercise.carapp.model.ApplicationError;
import com.exercise.carapp.model.Car;
import com.exercise.carapp.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RestController
@Api(value = "Car Operations", tags = "Cars", description = "Car data operations")
public class CarController  {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars", produces = {"application/json"})
    @ApiOperation(value = "${CarController.getCars.value}", tags = "Cars")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Car.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ApplicationError.class)
    })
    public CompletionStage<ResponseEntity<List<Car>>> getCars() {
        return CompletableFuture.completedFuture(ResponseEntity
                .status(HttpStatus.OK)
                .body(this.carService.getCars()));
    }

    @GetMapping(value = "/cars/{id}", produces = {"application/json"})
    @ApiOperation(value = "${CarController.getCar.value}", tags = "Cars")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Car.class),
            @ApiResponse(code = 404, message = "Not Found", response = ApplicationError.class),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ApplicationError.class)
    })
    public CompletionStage<ResponseEntity<Car>> getCar(@PathVariable Long id) {
        return CompletableFuture.completedFuture(ResponseEntity
                .status(HttpStatus.OK)
                .body(this.carService.getCar(id)));
    }

}

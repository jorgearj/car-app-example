package com.exercise.carapp.controller;

import com.exercise.carapp.exception.CarNotFoundException;
import com.exercise.carapp.model.ApplicationError;
import com.exercise.carapp.model.Car;
import com.exercise.carapp.model.Route;
import com.exercise.carapp.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @ApiOperation(value = "Gets a list of all cars", tags = "Cars")
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
    @ApiOperation(value = "Get a single car by its Id", tags = "Cars")
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

    @DeleteMapping(value = "/cars/{id}", produces = {"application/json"})
    @ApiOperation(value = "Removes an existing car", tags = "Cars")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Car.class),
            @ApiResponse(code = 404, message = "Not Found", response = ApplicationError.class),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ApplicationError.class)
    })
    public CompletionStage<ResponseEntity<Long>> deleteCar(@PathVariable Long id) {
        return CompletableFuture.completedFuture(ResponseEntity
                .status(HttpStatus.OK)
                .body(this.carService.removeCar(id)));
    }

    @PostMapping(value = "/cars", produces = {"application/json"})
    @ApiOperation(value = "Adds a new car", tags = "Cars")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Car.class),
            @ApiResponse(code = 404, message = "Not Found", response = ApplicationError.class),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ApplicationError.class)
    })
    public CompletionStage<ResponseEntity<Car>> addCar(@RequestBody Car car) {
        return CompletableFuture.completedFuture(ResponseEntity
                .status(HttpStatus.OK)
                .body(this.carService.addCar(car)));
    }

    @GetMapping(value = "/cars/{id}/route", produces = {"application/json"})
    @ApiOperation(value = "Calculates a route for a starting and ending point using an existing car", tags = "Cars")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Route.class),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ApplicationError.class)
    })
    public CompletionStage<ResponseEntity<Route>> getCarRoute(@PathVariable Long id,
                                                              @RequestParam(name = "partida") String start,
                                                              @RequestParam(name = "destino") String end) {
        return CompletableFuture.completedFuture(ResponseEntity
                .status(HttpStatus.OK)
                .body(this.carService.getCarRoute(id, start, end)));
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> handleNotFoundExceptions(CarNotFoundException e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApplicationError.builder()
                        .errorCode(404)
                        .path(request.getServletPath())
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message("The requested car does not exist")
                        .build());
    }
}

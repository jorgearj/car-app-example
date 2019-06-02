package com.exercise.carapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {
    private Coordinate startingPoint;
    private Coordinate endingPoint;
    private BigDecimal fuelCost;
    private BigDecimal distance;
    private Long duration;
}

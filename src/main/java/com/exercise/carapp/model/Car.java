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
public class Car {
    private Long id;
    private String marca;
    private String modelo;
    private String matricula;
    private BigDecimal consumoCombinado;
}

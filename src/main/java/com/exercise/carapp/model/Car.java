package com.exercise.carapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String marca;
    private String modelo;
    private String matricula;
    private BigDecimal consumoCombinado;
}

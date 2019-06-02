package com.exercise.carapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationError {
    private Integer errorCode;
    private Integer statusCode;
    private String message;
    private String path;
}

package com.example.vehicle_diagnostics.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class VehicleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    @Max(200)
    private Double speed;

    @NotNull
    @Min(0)
    @Max(100)
    private Double batterySoc;

    @NotNull
    @Min(0)
    @Max(100)
    private Double tyrePressure;

    @NotNull
    @Min(0)
    @Max(200)
    private Double engineTemp;

    private String healthStatus;
}

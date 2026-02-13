package com.example.vehicle_diagnostics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VehicleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double speed;
    private double batterySoc;
    private double tyrePressure;
    private double engineTemp;

    private String healthStatus;
}

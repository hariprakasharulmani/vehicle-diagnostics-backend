package com.example.vehicle_diagnostics.repository;

import com.example.vehicle_diagnostics.entity.VehicleData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleData, Long> {
}

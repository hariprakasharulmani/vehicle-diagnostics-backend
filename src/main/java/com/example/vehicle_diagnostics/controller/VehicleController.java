package com.example.vehicle_diagnostics.controller;
import java.util.List;
import java.util.Map;

import com.example.vehicle_diagnostics.entity.VehicleData;
import com.example.vehicle_diagnostics.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @PostMapping("/predict")
    public Map<String, String> predictRisk(@RequestBody VehicleData data) {
        String prediction = vehicleService.predictFailureRisk(data);
        return Map.of("prediction", prediction);
    }


    @GetMapping
    public List<VehicleData> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public VehicleData addVehicleData(@RequestBody VehicleData data) {
        return vehicleService.saveVehicleData(data);
    }
}

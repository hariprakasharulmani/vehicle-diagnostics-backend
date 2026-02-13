package com.example.vehicle_diagnostics.service;
import java.util.List;
import com.example.vehicle_diagnostics.entity.VehicleData;
import com.example.vehicle_diagnostics.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public String predictFailureRisk(VehicleData data) {

        // Simple ML-like logic simulation
        if (data.getEngineTemp() > 85 && data.getBatterySoc() < 30) {
            return "HIGH FAILURE RISK";
        } else if (data.getEngineTemp() > 80) {
            return "MODERATE RISK";
        } else {
            return "LOW RISK";
        }
    }

    public VehicleData saveVehicleData(VehicleData data) {

        // Simple health analysis logic
        if (data.getTyrePressure() < 30) {
            data.setHealthStatus("TYRE RISK");
        } else if (data.getBatterySoc() < 25) {
            data.setHealthStatus("LOW BATTERY");
        } else if (data.getEngineTemp() > 80) {
            data.setHealthStatus("ENGINE OVERHEAT");
        } else {
            data.setHealthStatus("NORMAL");
        }

        return vehicleRepository.save(data);
    }
    public List<VehicleData> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}

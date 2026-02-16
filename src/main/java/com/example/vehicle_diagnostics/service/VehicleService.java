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

        String prediction;

        if (data.getEngineTemp() > 120) {
            prediction = "ENGINE OVERHEAT";
        }
        else if (data.getBatterySoc() < 20) {
            prediction = "BATTERY LOW";
        }
        else if (data.getTyrePressure() < 20) {
            prediction = "TYRE PRESSURE LOW";
        }
        else if (data.getSpeed() > 150) {
            prediction = "OVERSPEED RISK";
        }
        else {
            prediction = "LOW RISK";
        }

        data.setHealthStatus(prediction);
        vehicleRepository.save(data);

        return prediction;
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

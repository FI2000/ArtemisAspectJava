package com.aaj.Controller;

import com.aaj.Persistence.Model.VehicleLog;
import com.aaj.Persistence.VehicleLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars") // optional base route
public class CarController {

    @Autowired
    private VehicleLogRepository vehicleLogRepository;

    @GetMapping("/lamborghini")
    public void lamborghini() {
        // Empty method
    }

    @GetMapping("/mazda")
    public void mazda() {
        // Empty method
    }

    @GetMapping("/bugatti")
    public void bugatti() {
        // Empty method
    }

    @GetMapping("/ferrari")
    public void ferrari() {
        // Empty method
    }

    @GetMapping("/porsche")
    public void porsche() {
        // Empty method
    }

    @GetMapping("/audi")
    public void audi() {
        // Empty method
    }

    @GetMapping("/mercedes")
    public void mercedes() {
        // Empty method
    }

    @GetMapping("/bmw")
    public void bmw() {
        // Empty method
    }

    @GetMapping("/tesla")
    public void tesla() {
        // Empty method
    }

    @GetMapping("/rollsRoyce")
    public void rollsRoyce() {
        // Empty method
    }

    @GetMapping()
    public ResponseEntity<List<VehicleLog>> retrieveCars(@RequestParam String brand) {
        List<VehicleLog> vehicleLogs = vehicleLogRepository.findByBrandAndVehicleType(brand, VehicleLog.VehicleType.CAR);
        return new ResponseEntity<>(vehicleLogs, HttpStatus.OK);
    }

}

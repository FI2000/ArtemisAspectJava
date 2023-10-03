package com.aaj.Controller;

import com.aaj.Messaging.LogMessenger;
import com.aaj.Persistence.Model.VehicleLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralController {

    @Autowired
    private LogMessenger logMessenger;

    @GetMapping("/logs/cars")
    public ResponseEntity<List<VehicleLog>> getAllCars() {
        List<VehicleLog> allVehicles = logMessenger.drainCarCache();
        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }

    @GetMapping("/logs/trucks")
    public ResponseEntity<List<VehicleLog>> getAllTrucks() {
        List<VehicleLog> allVehicles = logMessenger.drainTruckCache();
        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }

    @GetMapping("/logs/micros")
    public ResponseEntity<List<VehicleLog>> getAllMicros() {
        List<VehicleLog> allVehicles = logMessenger.drainMicroCache();
        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }


    @GetMapping("/logs")
    public ResponseEntity<List<VehicleLog>> getAllLogs() {
        List<VehicleLog> allLogs = new ArrayList<>();

        allLogs.addAll(logMessenger.drainCarCache());
        allLogs.addAll(logMessenger.drainTruckCache());
        allLogs.addAll(logMessenger.drainMicroCache());

        return new ResponseEntity<>(allLogs, HttpStatus.OK);
    }

    // Total price from cars
    // Total price from x brand
    // Number of x type bought
    // money/number


}

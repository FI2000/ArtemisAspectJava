package com.aaj.Controller;

import com.aaj.Persistence.Model.VehicleLog;
import com.aaj.Persistence.VehicleLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralController {

    @Autowired
    private VehicleLogRepository vehicleLogRepository;

    @GetMapping("/all")
    public ResponseEntity<List<VehicleLog>> getAllVehicles() {
        List<VehicleLog> allVehicles = vehicleLogRepository.findAll();
        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }

}

package com.aaj.GraphQLResolvers;

import com.aaj.Persistence.Model.VehicleLog;
import com.aaj.Persistence.VehicleLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehicleLogQuery {

    @Autowired
    private VehicleLogRepository vehicleLogRepository;

    @QueryMapping
    public List<VehicleLog> findAllVehicleLogs() {
        System.out.println("Retrieving all vehicles for graphql");
        return vehicleLogRepository.findAll();
    }

    @QueryMapping
    public List<VehicleLog> findVehicleLogsByVehicleType(@Argument String vehicleType) {

        return vehicleLogRepository.findByVehicleType(VehicleLog.VehicleType.valueOf(vehicleType));
    }

    @QueryMapping
    public List<VehicleLog> findVehicleLogsByBrand(@Argument String brand) {

        return vehicleLogRepository.findByBrand(brand);
    }

    @QueryMapping
    public List<VehicleLog> findVehicleLogsByBrandAndVehicleType(@Argument String brand, @Argument String vehicleType) {

        return vehicleLogRepository.findByBrandAndVehicleType(brand, VehicleLog.VehicleType.valueOf(vehicleType));
    }
}
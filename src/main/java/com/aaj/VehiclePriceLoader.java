package com.aaj;

import com.aaj.Persistence.Model.VehicleLog;
import com.aaj.Persistence.Model.VehiclePrices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VehiclePriceLoader implements ApplicationRunner {

    @Autowired
    private ResourceLoader resourceLoader;

    @Getter
    private VehiclePrices vehiclePrices;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:vehiclePrices.json");
        ObjectMapper mapper = new ObjectMapper();
        this.vehiclePrices = mapper.readValue(resource.getInputStream(), VehiclePrices.class);
    }

    public Double getPrice(VehicleLog.VehicleType vehicleType, String methodName) {
        Map<String, Double> modelPriceMap = switch (vehicleType) {
            case CAR -> vehiclePrices.getCar();
            case MICRO_MOBILITY -> vehiclePrices.getMicroMobility();
            case TRUCK -> vehiclePrices.getTruck();
        };

        if (modelPriceMap != null) {
            return modelPriceMap.getOrDefault(methodName, 0.0);
        }
        return 0.0;
    }
}

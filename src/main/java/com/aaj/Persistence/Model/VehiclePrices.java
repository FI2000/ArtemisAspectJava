package com.aaj.Persistence.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class VehiclePrices {
    @JsonProperty("Car")
    private Map<String, Double> Car;
    @JsonProperty("MicroMobility")
    private Map<String, Double> MicroMobility;
    @JsonProperty("Truck")
    private Map<String, Double> Truck;
}
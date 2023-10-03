package com.aaj.LoggingAspect;

import com.aaj.Messaging.LogMessenger;
import com.aaj.Persistence.Model.VehicleLog;
import com.aaj.Persistence.VehicleLogRepository;
import com.aaj.VehiclePriceLoader;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.aaj.Persistence.Model.VehicleLog.VehicleType.*;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Autowired
    private VehicleLogRepository vehicleLogRepository;
    @Autowired
    private VehiclePriceLoader vehiclePriceLoader;
    @Autowired
    private LogMessenger logMessenger;

    @Before("execution(* com.aaj.Controller.CarController.*(..))")
    public void logCarControllerMethods(JoinPoint joinPoint) {
        logMethodExecution(joinPoint, CAR);
    }

    @Before("execution(* com.aaj.Controller.TruckController.*(..))")
    public void logTruckControllerMethods(JoinPoint joinPoint) {
        logMethodExecution(joinPoint, TRUCK);
    }

    @Before("execution(* com.aaj.Controller.MicroMobilityController.*(..))")
    public void logMicroMobilityControllerMethods(JoinPoint joinPoint) {
        logMethodExecution(joinPoint, MICRO_MOBILITY);
    }

    private void logMethodExecution(JoinPoint joinPoint, VehicleLog.VehicleType vehicleType) {
        String methodName = joinPoint.getSignature().getName();
        VehicleLog vehicleLog = VehicleLog.builder()
                .brand(methodName)
                .purchaseDate(new Date())
                .vehicleType(vehicleType)
                .purchasePrice(vehiclePriceLoader.getPrice(vehicleType, methodName)).build();

        this.sendMessage(vehicleLog);
        vehicleLogRepository.save(vehicleLog);

        log.info("Executing method {}, Purchased Vehicle: {}", methodName, vehicleLog);
    }

    private void sendMessage(VehicleLog log) {
        switch (log.getVehicleType()) {
            case CAR -> logMessenger.sendCarMessage(log);
            case TRUCK -> logMessenger.sendTruckMessage(log);
            case MICRO_MOBILITY -> logMessenger.sendMicroMessage(log);
        }
    }
}

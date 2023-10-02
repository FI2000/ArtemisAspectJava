package com.aaj.LoggingAspect;

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

    @Before("execution(* com.aaj.Controller.CarController.*(..)) && !execution(* com.aaj.Controller.CarController.retrieveCars(..))")
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

    @Before("execution(* com.aaj.Controller.CarController.retrieveCars(..))")
    public void logRetrieveCarsMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Executing method {}, Retrieving all cars", methodName);
    }

    private void logMethodExecution(JoinPoint joinPoint, VehicleLog.VehicleType vehicleType) {
        String methodName = joinPoint.getSignature().getName();

        VehicleLog vehicleLog = VehicleLog.builder()
                .brand(methodName)
                .purchaseDate(new Date())
                .vehicleType(vehicleType)
                .purchasePrice(vehiclePriceLoader.getPrice(vehicleType, methodName)).build();


        vehicleLogRepository.save(vehicleLog);

        log.info("Executing method {}, Purchased Vehicle: {}", methodName, vehicleLog);
    }
}

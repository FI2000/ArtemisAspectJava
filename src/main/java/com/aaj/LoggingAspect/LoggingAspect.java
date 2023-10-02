package com.aaj.LoggingAspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.aaj.Controller.CarController.*(..))")
    public void logCarControllerMethods(JoinPoint joinPoint) {
        logCarMethodExecution(joinPoint);
    }

    @Before("execution(* com.aaj.Controller.TruckController.*(..))")
    public void logTruckControllerMethods(JoinPoint joinPoint) {
        logTruckMethodExecution(joinPoint);
    }

    @Before("execution(* com.aaj.Controller.MicroMobilityController.*(..))")
    public void logMicroMobilityControllerMethods(JoinPoint joinPoint) {
        logMicroMethodExecution(joinPoint);
    }

    private void logCarMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Executing method " + methodName + " with arguments: " + java.util.Arrays.toString(args));
    }

    private void logTruckMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Executing method " + methodName + " with arguments: " + java.util.Arrays.toString(args));
    }

    private void logMicroMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Executing method " + methodName + " with arguments: " + java.util.Arrays.toString(args));
    }
}

package com.aaj.LoggingAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.aaj.Controller.LoggingController.*(..))")
    public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // Log before method execution
        System.out.println("Executing method " + methodName + " with arguments: " + java.util.Arrays.toString(args));

        // Proceed with the original method invocation
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            // Log exception if any and rethrow
            System.out.println("Method " + methodName + " has thrown an exception: " + e.getMessage());
            throw e;
        }

        // Log after method execution
        System.out.println("Method " + methodName + " returned: " + result);

        return result;
    }
}

package com.queue.your.patient.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Aspect
public class TimingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimingAspect.class);

    @Around("@annotation(Timed)")
    public Object timeOfExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        final StopWatch executionTime = new StopWatch();
        executionTime.start();
        try{
            return joinPoint.proceed();
        } finally {
            executionTime.stop();
            LOGGER.info("Execution of [{}] took {} ms", joinPoint.getSignature(), executionTime.getTotalTimeMillis());
        }

    }
}

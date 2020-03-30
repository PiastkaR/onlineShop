package com.queue.your.patient.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import static java.lang.String.format;

@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(com.queue.your.patient..*Service)")
    void throwingPointcut() {
        //method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Pointcut("within(com.queue.your.patient..*Repository)")
    void allRepositories() {}

    @AfterThrowing(pointcut = "throwingPointcut()", throwing = "e")
    void logAfterThrowing(JoinPoint jointPoint, Throwable e) {
        LOGGER.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'",
        jointPoint.getSignature().getDeclaringTypeName(),
                jointPoint.getSignature().getName(),
                e.getCause() !=null ? e.getCause() : "Null",
                e.getMessage(),
                e
                );
    }

    @Around("allRepositories()")
    Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        log(joinPoint, stopWatch, result);
        return result;
    }

    private void log(ProceedingJoinPoint joinPoint, StopWatch stopWatch, Object result) {
        String operationName = getOperationName(joinPoint);
        String timerString = createTimerString(stopWatch);
        String resultingString = createResultString(result);
        if(!timerString.isEmpty() || !resultingString.isEmpty()){
            Logger logger = getLogger(joinPoint);
            LOGGER.info("{}{} {}", operationName, timerString, resultingString);
        }
    }
    private Logger getLogger(ProceedingJoinPoint joinPoint) {
        return LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
    }

    private String createResultString(Object result){
        return format("opertion result: %s", result);
    }

    private String createTimerString(StopWatch stopWatch) {
        long mills = stopWatch.getTotalTimeMillis();
        return format(" [%d ms]", mills);
    }

    private String getOperationName(ProceedingJoinPoint joinPoint) {
        String classWithPackageName = joinPoint.getSignature().getDeclaringTypeName();
        String className = classWithPackageName.substring(classWithPackageName.lastIndexOf('.') + 1);
        return className + "." + joinPoint.getSignature().getName();
    }
}

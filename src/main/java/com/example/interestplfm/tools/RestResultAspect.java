package com.example.interestplfm.tools;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaohongbin
 * @since 2024/07/20
 **/
@Aspect
@Component
public class RestResultAspect {

    @Around("execution(* com.example.interestplfm.service.*.*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            Map<String, Object> extension = new HashMap<>();
            extension.put("error", e.getMessage());
            return RestResult.buildFailure(extension);
        }
    }

}

package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author houlei
 * @DESC:aop切面
 * @create 2019-03-07 10:06
 */
@Component
@Aspect
@Slf4j
public class AnnotaionAspect {
    //配置切入点 该方法无方法体 主要是方便同类中其他方法使用此配置的切入点
    @Pointcut("execution(* com.example.demo.common..*(..))")
    public void aspect(){}

    @Before("aspect()")
    public void before(){
        log.info("方法执行前执行====");

    }
    @After("aspect()")
    public void after(){
        log.info("方法执行后执行====");
    }

    @Around("aspect()")
    public void around(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try {
            Object proceed = ((ProceedingJoinPoint) joinPoint).proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }


}

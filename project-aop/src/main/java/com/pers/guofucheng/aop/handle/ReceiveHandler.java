package com.pers.guofucheng.aop.handle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
@Component
@Aspect
public class ReceiveHandler {

    @Pointcut("execution(* com.pers.guofucheng.aop.controller.MessageReceiverController*.*(..))")
    private void excutePoint(){

    }

    @Around("excutePoint()")
    public Object around (ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("执行目标方法之前...");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("执行目标方法之后...");
        return obj;

    }
}

package com.pers.guofucheng.aop.handle;

import com.pers.guofucheng.aop.annotation.OperationLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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
public class OperateLogAspect {

//    @Pointcut("execution(* com.pers.guofucheng.aop.controller.MessageReceiverController*.*(..))")
//    private void excutePoint(){
//
//    }
    @Pointcut("@annotation(com.pers.guofucheng.aop.annotation.OperationLog)")
    private void excutePoint(){

    }

    @Around("excutePoint()")
    public Object around (ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("执行目标方法之前...");
        OperationLog systemLog = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod().getAnnotation(OperationLog.class);
        String s = systemLog.operationName();
        System.out.println("执行目标方法之后...");
        return systemLog;

    }
//    @Around("excutePoint()")
//    public Object around (ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        System.out.println("执行目标方法之前...");
//        Object obj = proceedingJoinPoint.proceed();
//        System.out.println("执行目标方法之后...");
//        return obj;
//
//    }
}

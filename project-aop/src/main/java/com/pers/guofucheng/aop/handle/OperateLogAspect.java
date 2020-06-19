package com.pers.guofucheng.aop.handle;

import com.alibaba.fastjson.JSON;
import com.pers.guofucheng.aop.annotation.OperationLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AOP
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
@Component
@Aspect//声明这是一个切面
public class OperateLogAspect {
    Logger logger = LoggerFactory.getLogger(OperateLogAspect.class);

    @Pointcut("execution(* com.pers.guofucheng.aop.controller.MessageReceiverController*.*(..))")//切入点 切入点表达式
    private void excutePointMethod(){

    }
    @Pointcut("@annotation(com.pers.guofucheng.aop.annotation.OperationLog)")//切入点 切入点表达式
    private void excutePointAnno(){

    }

    /**
     * 环绕通知=前置+目标方法执行+后置通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("excutePointAnno()")
    public Object aroundAnno (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("执行目标方法之前...");
        OperationLog systemLog = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod().getAnnotation(OperationLog.class);
        String operationName = systemLog.operationName();
        String operationType = systemLog.operationType();
        logger.info("operationName:{},operationType:{}",operationName,operationType);
        //执行目标方法
        Object object = proceedingJoinPoint.proceed();
        logger.info("执行目标方法之后...");
        return object;

    }
    @Around("excutePointMethod()")
    public Object aroundMethod (ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        logger.info("执行目标方法之前...");
        Object obj = proceedingJoinPoint.proceed();
        logger.info("obj:{}", JSON.toJSONString(obj));
        logger.info("执行目标方法之后...");
        return obj;

    }
}

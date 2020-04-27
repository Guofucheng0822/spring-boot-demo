package com.pers.guofucheng.aop.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {
    /**
     * 要执行的操作类型比如：add操作
     * @return
     */
    String operationType() default "";

    /**
     * 要执行的具体操作比如：添加用户
     * @return
     */
    String operationName() default "";
}

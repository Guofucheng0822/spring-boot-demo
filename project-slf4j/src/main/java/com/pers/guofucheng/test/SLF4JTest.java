package com.pers.guofucheng.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class SLF4JTest {
    public static void main(String[] args) {
        Logger log= LoggerFactory.getLogger(SLF4JTest.class);
        String message="日志";
        log.trace("trace:{}",message);
        log.debug("debug:{}",message);
        log.info("info:{}",message);
        log.warn("warn:{}",message);
        log.error("error:{}",message);
    }
}

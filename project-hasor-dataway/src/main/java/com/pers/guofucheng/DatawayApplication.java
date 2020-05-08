package com.pers.guofucheng;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guofucheng
 * @title SpringBoot+Dataway
 * @Description SpringBoot+Dataway
 * @Date 2020-5-1
 * @Copyright 2019-2020
 */

@EnableHasor
@EnableHasorWeb
@SpringBootApplication
public class DatawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatawayApplication.class, args);
    }
}

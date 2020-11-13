package com.pers.guofucheng.spi;

/**
 * Spi服务ImplB
 *
 * @author guofucheng
 * @date 2020/11/13
 */
public class SpiServiceBImpl implements SpiService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "! from service-b");
    }
}
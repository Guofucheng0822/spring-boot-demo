package com.pers.guofucheng.spi;

/**
 * Spi服务ImplA
 *
 * @author guofucheng
 * @date 2020/11/13
 */
public class SpiServiceAImpl implements SpiService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "! from service-a");
    }
}
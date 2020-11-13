package com.pers.guofucheng.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) {
        // 1.通过ServiceLoader加载
        ServiceLoader<SpiService> loadedParsers = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = loadedParsers.iterator();
        while (iterator.hasNext()){
            SpiService spiService = iterator.next();
            spiService.sayHello("hhhhhhhhhh");
        }
        System.out.println("==========================================");
        // 2.通过Service加载
        Iterator<SpiService> providers = Service.providers(SpiService.class);
        while (providers.hasNext()){
            SpiService spiService = providers.next();
            spiService.sayHello("hhhhhhhhhh");
        }
    }
}
package com.pers.guofucheng.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<SpiService> loadedParsers = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = loadedParsers.iterator();
        while (iterator.hasNext()){
            SpiService spiService = iterator.next();
            spiService.sayHello("hhhhhhhhhh");
        }
    }
}
package com.ps.gfc.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 * @author guofucheng
 */
public class KeyUtils {

    public synchronized static String key6() {
        return RandomStringUtils.randomAlphanumeric(6);
    }

    public synchronized static String key16() {
        return RandomStringUtils.randomAlphanumeric(16);
    }

    public static String uuid32() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}

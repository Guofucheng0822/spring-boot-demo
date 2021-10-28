package com.pers.guofucheng.shenyu;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Shenyu模拟三方调用测试
 *
 * @author guofucheng
 */
public class ShenyuDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //第一步：首先构造一个 Map 。
        Map<String, String> map = new HashMap<>(3);
        //timestamp为毫秒数的字符串形式 String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli())
        String currentTimeMillis = String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        map.put("timestamp", currentTimeMillis);
        map.put("path", "/http/order/findById");
        map.put("version", "1.0.0");
        String sign = generateSign("068556A6C5BB40C2A909A90EE94EF98D", map);
        System.out.println(currentTimeMillis);
        System.out.println(sign);
    }
    public static String generateSign(final String signKey, final Map<String, String> params) {
        List<String> storedKeys = Arrays.stream(params.keySet()
                .toArray(new String[]{}))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        final String sign = storedKeys.stream()
                .filter(key -> !Objects.equals(key, "sign"))
                .map(key -> String.join("", key, params.get(key)))
                .collect(Collectors.joining()).trim()
                .concat(signKey);
        // TODO this is a risk for error charset coding with getBytes
        return DigestUtils.md5DigestAsHex(sign.getBytes()).toUpperCase();
    }
}

package com.keanest.framework.utils;

import java.util.UUID;

public class RandomDataUtil {

    public static String randomEmail() {
        return "test_" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com";
    }
}

package com.keanest.framework.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties runProperties = new Properties();

    static {
        try {
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/run-config.properties");

            if (input == null) {
                throw new RuntimeException("run-config.properties not found");
            }

            runProperties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load run-config.properties", e);
        }
    }

    public static String getRunProperty(String key) {
        return runProperties.getProperty(key);
    }
}

package com.keanest.framework.config;

import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties envProperties = new Properties();

    static {
        try {
            String env = ConfigReader.getRunProperty("env");

            InputStream input = EnvironmentConfig.class
                    .getClassLoader()
                    .getResourceAsStream("config/" + env + ".properties");

            if (input == null) {
                throw new RuntimeException(env + ".properties not found");
            }

            envProperties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load environment properties", e);
        }
    }

    public static String getEnvProperty(String key) {
        return envProperties.getProperty(key);
    }
}

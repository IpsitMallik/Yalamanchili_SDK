package com.narada.sdk.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load configuration properties", ex);
        }
    }

    public static String getUsername() {
        return properties.getProperty("api.user.id");
    }

    public static String getPassword() {
        return properties.getProperty("api.password");
    }

    public static String getClientId() {
        return properties.getProperty("client.id");
    }

    public static String getClientCountryZone() {
        return properties.getProperty("client.country.zone");
    }
    
    public static String getMaxRetries() {
        return properties.getProperty("max.retries");
    }

    public static String getPvtKeyFilePath() {
        return properties.getProperty("pvt.key.file.path");
    }

    public static String getCertFilePath() {
        return properties.getProperty("public.certificate.file.path");
    }
}

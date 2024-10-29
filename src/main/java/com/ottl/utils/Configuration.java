package com.ottl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;
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
        return getPath(properties.getProperty("pvt.key.file.path"));
    }

    public static String getCertFilePath() {
        return getPath(properties.getProperty("public.certificate.file.path"));
    }

    private static String getPath(String relativePath) {
        try {
            return Paths.get(Configuration.class.getClassLoader().getResource(relativePath).toURI()).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid URI syntax for path: " + relativePath, e);
        } catch (NullPointerException e) {
            throw new RuntimeException("Resource not found: " + relativePath, e);
        }
    }
}

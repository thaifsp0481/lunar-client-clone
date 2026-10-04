package com.lunarstarter.client.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ClientConfig {
    private static final String CONFIG_PATH = "client.properties";
    private final Properties properties = new Properties();

    public void load() {
        Path path = Paths.get(CONFIG_PATH);
        if (Files.exists(path)) {
            try {
                properties.load(Files.newInputStream(path));
            } catch (IOException e) {
                System.err.println("Could not load config: " + e.getMessage());
            }
        }
    }

    public void save() {
        try {
            properties.store(Files.newOutputStream(Paths.get(CONFIG_PATH)), "Lunar-inspired client settings");
        } catch (IOException e) {
            System.err.println("Could not save config: " + e.getMessage());
        }
    }

    public void set(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        String value = properties.getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(value);
    }

    public void setBoolean(String key, boolean value) {
        properties.setProperty(key, Boolean.toString(value));
    }
}

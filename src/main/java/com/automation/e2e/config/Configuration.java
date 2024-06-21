package com.automation.e2e.config;

import java.util.Optional;

public class Configuration {

    private static TestConfig config;

    private Configuration() {
    }

    public static TestConfig getConfig() {
        if (config == null) {
            config = initConfiguration("conf/config.properties", TestConfig.class);
        }
        return config;
    }

    private static <T> T initConfiguration(String configFile, Class<T> clazz) {
        String prefix = Optional.ofNullable(System.getProperty("target_env"))
                .orElseThrow(() -> new RuntimeException("No environment specified"));
        return initConfiguration(configFile, clazz, prefix);
    }

    private static <T> T initConfiguration(String configFile, Class<T> clazz, String prefix) {
        ConfigManager configManager = new ConfigManager();
        configManager
                .setConfigFilename(configFile)
                .init();
        return configManager.readConfigurationOf(clazz, Optional.ofNullable(prefix).orElse("dev"));
    }
}

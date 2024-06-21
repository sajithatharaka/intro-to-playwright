package com.automation.e2e.config;

import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.classpath.ClasspathConfigurationSource;
import org.cfg4j.source.context.filesprovider.ConfigFilesProvider;

import java.nio.file.Paths;
import java.util.List;

public class ConfigManager {

    private ConfigFilesProvider configFilesProvider;
    private ConfigurationSource source;
    private ConfigurationProvider provider;
    private String configFilename;

    public ConfigManager() {
    }

    public void init() {
        configFilesProvider = () -> List.of(Paths.get(configFilename));

        source = new ClasspathConfigurationSource(configFilesProvider);

        provider = new ConfigurationProviderBuilder()
                .withConfigurationSource(source)
                .build();
    }

    public <T> T readConfigurationOf(Class<T> type, String environment) {
        T testConfig = provider.bind(environment, type);
        return testConfig;
    }

    public String getConfigFilename() {
        return configFilename;
    }

    public ConfigManager setConfigFilename(String configFilename) {
        this.configFilename = configFilename;
        return this;
    }

}

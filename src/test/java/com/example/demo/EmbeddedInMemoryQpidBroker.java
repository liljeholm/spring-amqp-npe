package com.example.demo;

import org.apache.qpid.server.SystemLauncher;
import org.apache.qpid.server.configuration.IllegalConfigurationException;
import org.apache.qpid.server.model.SystemConfig;

import java.net.URL;
import java.util.Map;

public class EmbeddedInMemoryQpidBroker {
    private static final String DEFAULT_INITIAL_CONFIGURATION_LOCATION = "qpid-embedded-inmemory-configuration.json";

    private final SystemLauncher systemLauncher;

    public EmbeddedInMemoryQpidBroker() {
        this.systemLauncher = new SystemLauncher();
    }

    public void start() throws Exception {
        this.systemLauncher.startup(createSystemConfig());
    }

    public void shutdown() {
        this.systemLauncher.shutdown();
    }

    private static Map<String, Object> createSystemConfig() throws IllegalConfigurationException {
        URL initialConfigUrl = EmbeddedInMemoryQpidBroker.class.getClassLoader()
                .getResource(DEFAULT_INITIAL_CONFIGURATION_LOCATION);
        if (initialConfigUrl == null) {
            throw new IllegalConfigurationException(
                    "Configuration location '" + DEFAULT_INITIAL_CONFIGURATION_LOCATION + "' not found");
        }
        return Map.of(
                SystemConfig.TYPE, "Memory",
                SystemConfig.INITIAL_CONFIGURATION_LOCATION, initialConfigUrl.toExternalForm(),
                SystemConfig.STARTUP_LOGGED_TO_SYSTEM_OUT, true);
    }
}

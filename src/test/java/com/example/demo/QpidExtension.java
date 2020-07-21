package com.example.demo;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class QpidExtension implements BeforeAllCallback, AfterAllCallback {

    private EmbeddedInMemoryQpidBroker broker;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        broker = new EmbeddedInMemoryQpidBroker();
        broker.start();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        broker.shutdown();
    }
}   

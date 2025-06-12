package de.paulmannit.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Startup {
    @Inject
    PixooService pixooService;

    @io.quarkus.runtime.Startup
    public void startup() {
        Log.info("Startup system");
        pixooService.initialize();
    }
}

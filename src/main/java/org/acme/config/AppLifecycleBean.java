package org.acme.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger log = Logger.getLogger("ListenerBean");

    void onStart(@Observes StartupEvent ev) {
        log.info("The application is starting...");
    }

    void onStop(@Observes ShutdownEvent ev) {
        log.info("The application is stopping...");
    }

}

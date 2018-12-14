package org.suw.learn.metis.commons.loader;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.suw.learn.gaea.log.FunIMsgFormat;

/**
 * The unified entry of Bootstrap
 * Using JDK ShutdownHook to gracefully shutdown the application.
 * Set system property "shutdown.hook"=true to enable this feature.
 */
@Slf4j
public class Main {
    private static volatile boolean running = true;

    public static void main(String... string) {
        Validate.inclusiveBetween(0, 2, string.length);
        String loaderClassName = string[0];
        Validate.notEmpty(loaderClassName);
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            final Loader loader = Loader.class.cast(Class.forName(loaderClassName, true, cl).newInstance());
            Validate.notNull(loader, "Can not find loader Class: " + loaderClassName);
            setShutdownHook(loader);
            loader.start();
            log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat("Application started!"));
        } catch (Exception e) {
            log.error("Exception encountered during start", e);
        }
        synchronized (Main.class) {
            while (running) {
                try {
                    Main.class.wait();
                } catch (InterruptedException e) {
                    log.error("Exception encountered main threat wait", e);
                }
            }
        }
    }

    /**
     * Adding JDK ShutdownHook
     * When using kill PID, the hook will be invoked to shutdown the application gracefully
     *
     * @param loader Loader instance, eg. spring container
     */
    private static void setShutdownHook(final Loader loader) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                loader.stop();
                log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat("Application stopped!"));
                synchronized (Main.class) {
                    running = false;
                    Main.class.notify();
                }
            }
        });
    }
}

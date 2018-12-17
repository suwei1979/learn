/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.loader;

/**
 * Loader Interface.
 */
public interface Loader {

  /**
   * Those which implements start method will focus on the application start up.
   * When the application start up, Main.main() will automatic invoke start method
   * to start up the application.
   */
  void start();

  /**
   * The stop method add to the ShutdownHook during the starting process.
   * When using linux command kill PID, the stop() method will be invoked.
   * So add the procedures during the shutting down.
   */
  void stop();
}

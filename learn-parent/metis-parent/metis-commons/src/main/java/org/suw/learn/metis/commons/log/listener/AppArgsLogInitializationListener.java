package org.suw.learn.metis.commons.log.listener;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.Validate;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.suw.learn.metis.commons.utils.LoggingUtils;

/**
 * Spring Boot Application listener.
 * When application start, listener will get properties and set them into
 * system properties, so that initialize the logging arguments.
 */
@Slf4j
public class AppArgsLogInitializationListener implements ApplicationListener {

  @Override
  public void onApplicationEvent(ApplicationEvent applicationEvent) {
    if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
      ApplicationEnvironmentPreparedEvent event = (ApplicationEnvironmentPreparedEvent) applicationEvent;
      String productId = event.getEnvironment().getProperty("system.productId");
      String moduleId = event.getEnvironment().getProperty("system.moduleId");
      String nodeId = event.getEnvironment().getProperty("system.nodeId");
      Validate.matchesPattern(productId, "[0-9a-zA-z -]+");
      Validate.matchesPattern(moduleId, "[0-9a-zA-z -]+");
      Validate.matchesPattern(nodeId, "[0-9a-fA-F]{3}");
      LoggingUtils.initSystemLoggingArgs(productId, moduleId, nodeId);
    }
  }
}

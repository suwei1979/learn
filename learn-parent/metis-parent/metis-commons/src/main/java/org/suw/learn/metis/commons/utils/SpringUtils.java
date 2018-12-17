/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.suw.learn.gaea.log.FunIMsgFormat;

/**
 * Spring Util For Bean Manangement.
 * Get bean factory after factory initialized
 */
@Slf4j
public final class SpringUtils implements ApplicationContextAware {

  private static ApplicationContext context;

  private static void setContext(final ApplicationContext context) {
    SpringUtils.context = context;
  }

  @Override
  public void setApplicationContext(final ApplicationContext context) {
    setContext(context);
  }

  @SuppressWarnings("unchecked")
  public static <T> T getBean(String name) {
    if (checkNull()) {
      return null;
    } else {
      return (T) context.getBean(name);
    }
  }

  public static <T> T getBean(final Class<T> clz) {
    if (checkNull()) {
      return null;
    } else {
      return context.getBean(clz);
    }
  }

  public static <T> T getBean(String name, final Class<T> clz) {
    if (checkNull()) {
      return null;
    } else {
      return context.getBean(name, clz);
    }
  }

  /**
   * Check context is null of not.
   *
   * @return booleanIf context is null, that is, standalone context, then return true;
   * Otherwise return false;
   */
  private static boolean checkNull() {
    if (context == null) {
      log.warn(FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat("Can not bind bean factory"));
      return true;
    }
    return false;
  }
}

/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.suw.learn.gaea.log.FunIMsgFormat;

import java.util.Locale;

/**
 * Message Util for messages and internationalization.
 * Using: in spring context
 * Precondition: messageSource bean should be defined.
 *
 * @author zgy
 */
@Slf4j
public final class MessageUtils {

  private static MessageSource messageSource;

  static {
    messageSource = SpringUtils.getBean(MessageSource.class);
  }

  /**
   * Get Chinese message from message source using message code.
   *
   * @param code message code or key
   * @param args elements to replace with the placeholders
   * @return the message from message source
   */
  public static String getMessage(String code, Object[] args) {
    return getMessage(code, args, Locale.CHINA);
  }

  /**
   * Get defaul local message from message source using message code.
   *
   * @param code message code or key
   * @param args elements to replace with the placeholders
   * @return the message from message source
   */
  public static String getMessageDefaultLocale(String code, Object[] args) {
    return getMessage(code, args, Locale.getDefault());
  }

  /**
   * Get Chinese message from message source using message code.
   *
   * @param code message code or key
   * @return the message from message source
   */
  public static String getMessage(String code) {
    return getMessage(code, null, Locale.CHINA);
  }

  /**
   * Get default locale message from message source using message code.
   *
   * @param code message code or key
   * @return the message from message source
   */
  public static String getMessageDefaultLocale(String code) {
    return getMessage(code, null, Locale.getDefault());
  }

  /**
   * Get message from message source using message code.
   *
   * @param code message code or key
   * @return the message from message source
   */
  public static String getMessage(String code, Object[] args, Locale locale) {
    if (messageSource == null) {
      return code;
    }
    try {
      String msg = messageSource.getMessage(code, args, locale);
      if (msg != null) {
        return msg;
      } else {
        return code;
      }
    } catch (NoSuchMessageException e) {
      log.error(FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat("No Such Code! Code : [{}]"), code, e);
      return code;
    }
  }

  private MessageUtils() {
  }
}

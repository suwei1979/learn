/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.log.annotation;

import java.lang.annotation.*;

/**
 * Annotation for business logging.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface BusiLog {
  /**
   * 返回模块名.
   *
   * @return 模块名，默认为""
   */
  String module() default "";

  /**
   * 返回操作名.
   *
   * @return 操作名, 默认为""
   */
  String operation() default "";

  /**
   * 是否记录方法的输入和输出.
   * 记录方法的输入和输出，便于调试
   *
   * @return true/false
   */
  boolean entry() default true;
}
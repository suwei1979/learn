package org.suw.learn.metis.commons.exception.annotation;

import java.lang.annotation.*;

/**
 * 异常记录注解
 * 通过dubbo调用服务时，dubbo filter可以处理异常.
 * 非dubbo服务调用时，使用@ExceptionHandler来捕获并记录异常.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ExceptionHandler {
  String module() default "";

  String operation() default "";
}
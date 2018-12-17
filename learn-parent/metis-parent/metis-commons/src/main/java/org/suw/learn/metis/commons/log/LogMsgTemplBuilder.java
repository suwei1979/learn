/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.log;

import org.apache.commons.lang3.Validate;
import org.suw.learn.gaea.log.GaeaLogMsgFormat;

/**
 * 日志组装器.
 * 根据易商功能日志协议，简化日志拼接过程，设计该组装器；
 * 采用Fluent编程风格
 * <p>
 * String log = LogBuilder.log("Connection refused!")
 * .add("cardNo")
 * .add("transferAmount")
 * .build();
 * </p>
 * 得到Connection refused!-/-cardNo-:-{}-/-transferAmount-:-{}
 */
public final class LogMsgTemplBuilder extends GaeaLogMsgFormat {

  private StringBuffer sb;

  public static LogMsgTemplBuilder log(final String statement) {
    return new LogMsgTemplBuilder().addStatement(statement);
  }

  private LogMsgTemplBuilder addStatement(final String statement) {
    if (statement != null && !statement.isEmpty()) {
      sb.append(statement);
    }
    return this;
  }

  public LogMsgTemplBuilder add(final String condition) {
    Validate.notNull(condition);
    if (sb.length() > 0) {
      sb.append(INFO_DIV);
    }
    sb.append(condition)
        .append(KV_DIV)
        .append(LOG_ARGUMENT);
    return this;
  }

  public String build() {
    return sb.toString();
  }

  private LogMsgTemplBuilder() {
    sb = new StringBuffer();
  }
}

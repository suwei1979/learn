/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.log.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.StopWatch;
import org.suw.learn.gaea.exception.GaeaExceptionConst;
import org.suw.learn.gaea.log.AppIMsgFormat;
import org.suw.learn.gaea.log.GaeaLogUtil;
import org.suw.learn.metis.commons.log.LogMsgTemplBuilder;
import org.suw.learn.metis.commons.log.LogProType;
import org.suw.learn.metis.commons.utils.LoggingUtils;
import org.suw.learn.metis.commons.web.filter.AbstractFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Log Filter.
 * Log http request from browser,
 * Initiate processId of one transaction
 */
@Slf4j
public class InteractionLoggingFilter extends AbstractFilter {

    private static final String REQ_MSG_PATTERN = LogMsgTemplBuilder.log("发起请求").add("Process Id").build();
    private static final String RESP_MSG_PATTERN = LogMsgTemplBuilder.log("返回响应").add("Process Id").add("http status").add("请求时间(ms)").build();

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logRequest();
        logRequestUUID();
        filterChain.doFilter(request, response);
        logResponseUUID();
        stopWatch.stop();
        logResponse(response, stopWatch.getTotalTimeMillis());
    }

    private void logRequestUUID() {
        log.info(AppIMsgFormat.MsgStyle.UUID.getFormat(),
                MDC.get("uuid"),
                AppIMsgFormat.ITR_UUID_NEW,
                AppIMsgFormat.ITR_READ_ACTION,
                LoggingUtils.getLogProperty(LogProType.PRODUCT_ID),
                LoggingUtils.getLogProperty(LogProType.MODULE_ID),
                LoggingUtils.getLogProperty(LogProType.NODE_ID),
                AppIMsgFormat.ITR_ACTION_SUCC,
                GaeaExceptionConst.NORMAL_RETCODE);
    }

    private void logRequest() {
        log.info(REQ_MSG_PATTERN, GaeaLogUtil.getProcessID());
    }

    private void logResponse(HttpServletResponse response, long duration) {
        log.info(RESP_MSG_PATTERN, GaeaLogUtil.getProcessID(), response.getStatus(), duration);
    }

    private void logResponseUUID() {
        log.info(AppIMsgFormat.MsgStyle.UUID.getFormat(),
                MDC.get("uuid"),
                AppIMsgFormat.ITR_UUID_OLD,
                AppIMsgFormat.ITR_WRITE_ACTION,
                LoggingUtils.getLogProperty(LogProType.PRODUCT_ID),
                LoggingUtils.getLogProperty(LogProType.MODULE_ID),
                LoggingUtils.getLogProperty(LogProType.NODE_ID),
                AppIMsgFormat.ITR_ACTION_SUCC,
                GaeaExceptionConst.NORMAL_RETCODE);
    }
}

package org.suw.learn.metis.commons.log.listener;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.suw.learn.gaea.log.FunIMsgFormat;
import org.suw.learn.gaea.log.GaeaLogUtil;
import org.suw.learn.metis.commons.log.LogMsgTemplBuilder;
import org.suw.learn.metis.commons.utils.IPUtils;
import org.suw.learn.metis.commons.utils.LoggingUtils;

import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 用户请求日志记录
 */
@Slf4j
public class LogRequestInfoListener implements ServletRequestListener {

    private static final String REQUEST_INFO = LogMsgTemplBuilder.log("Request Record").add("ip").add("locale").add("url").add("params").add("accept").add("userAgent").add("headers").build();

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        GaeaLogUtil.registerProcessID(LoggingUtils.createProcessOrInteractionId());
        GaeaLogUtil.registerInteractionUUID(LoggingUtils.createProcessOrInteractionId());
        String ip = IPUtils.getIpAddr(request);
        Locale locale = request.getLocale();
        String url = request.getRequestURI();
        String params = getParams(request);
        String accept = request.getHeader("accept");
        String userAgent = request.getHeader("User-Agent");
        String headers = getHeaders(request);
        log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat(REQUEST_INFO), ip, locale, url, params, accept, userAgent, headers);
    }

    private static String getParams(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        return JSON.toJSONString(params);
    }

    private static String getHeaders(HttpServletRequest request) {
        Map<String, List<String>> headers = Maps.newHashMap();
        Enumeration<String> namesEnumeration = request.getHeaderNames();
        while (namesEnumeration.hasMoreElements()) {
            String name = namesEnumeration.nextElement();
            Enumeration<String> valueEnumeration = request.getHeaders(name);
            List<String> values = Lists.newArrayList();
            while (valueEnumeration.hasMoreElements()) {
                values.add(valueEnumeration.nextElement());
            }
            headers.put(name, values);
        }
        return JSON.toJSONString(headers);
    }
}

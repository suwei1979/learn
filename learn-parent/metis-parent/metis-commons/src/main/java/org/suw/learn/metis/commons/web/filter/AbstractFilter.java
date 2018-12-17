/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.suw.learn.metis.commons.utils.ServletRequestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Base Servlet Filter.
 * 配置方式
 * <filter>
 * <!-- url分隔符可以是 换行 空格 分号  逗号  白名单和黑名单都是可选-->
 * <init-param>
 * <param-name>blackListURL</param-name> <!-- 配置黑名单url 表示不走过滤器的url order：1 -->
 * <param-value>
 * /aa
 * /bb/**
 * /cc/*
 * </param-value>
 * </init-param>
 * <init-param>
 * <param-name>whiteListURL</param-name> <!-- 配置白名单url 表示走过滤器的url order：2-->
 * <param-value>
 * /dd;/ee,/ff /list
 * </param-value>
 * </init-param>
 * </filter>
 * <filter-mapping>
 * <filter-name>TestFilter</filter-name>
 * <url-pattern>/*</url-pattern>
 * </filter-mapping>
 * <p/>
 */
@Slf4j
public abstract class AbstractFilter implements Filter {

    private static final String URL_SPLIT_PATTERN = "[, ;\r\n]";//逗号  空格 分号  换行
    private final PathMatcher pathMatcher = new AntPathMatcher();
    protected String currentURL;
    protected String queryString;
    protected String servletPath;
    private FilterConfig config = null;
    private List<String> whiteListURLs;
    private List<String> blackListURLs;

    @Override
    public final void init(FilterConfig config) throws ServletException {
        this.config = config;
        this.initConfig();
        this.init();
    }

    /**
     * 子类覆盖
     *
     * @throws ServletException exception
     */
    public void init() throws ServletException {
    }

    @Override
    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        currentURL = ServletRequestUtils.getCurrentURL(httpRequest);
        queryString = httpRequest.getQueryString();
        servletPath = ServletRequestUtils.getServletPath(httpRequest);
        if (isBlackURL(servletPath)) {
            chain.doFilter(request, response);
            return;
        }
        if (!isWhiteURL(servletPath)) {
            chain.doFilter(request, response);
            return;
        }
        doFilter(httpRequest, httpResponse, chain);
    }

    /**
     * 子类覆盖
     *
     * @param request  request
     * @param response response
     * @param chain    fiter chain
     * @throws IOException      exception
     * @throws ServletException exception
     */
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    /**
     * 子类覆盖
     */
    @Override
    public void destroy() {
    }

    /**
     * Method to get initial parameters of filter
     *
     * @param key param-name
     * @return param-value
     */
    protected String getParameter(String key) {
        String value = this.config.getInitParameter(key);
        Validate.notNull(value, "parameter-name: %s doesn't exists, please check!", key);
        return value;
    }

    private boolean isWhiteURL(String currentURL) {
        for (String whiteURL : whiteListURLs) {
            if (pathMatcher.match(whiteURL, currentURL)) {
                log.debug("url filter : white url list matches : [{}] match [{}] continue", currentURL, whiteURL);
                return true;
            }
        }
        log.debug("url filter : white url list not matches : [{}] not match [{}]",
                currentURL, whiteListURLs.toString());
        return false;
    }

    private boolean isBlackURL(String currentURL) {
        for (String blackURL : blackListURLs) {
            if (pathMatcher.match(blackURL, currentURL)) {
                log.debug("url filter : black url list matches : [{}] match [{}] break", currentURL, blackURL);
                return true;
            }
        }
        log.debug("url filter : black url list not matches : [{}] not match [{}]",
                currentURL, blackListURLs.toString());
        return false;
    }

    private void initConfig() {
        String whiteListURLStr = getParameter("whiteListURL");
        whiteListURLs = strToArray(whiteListURLStr);
        String blackListURLStr = getParameter("blackListURL");
        blackListURLs = strToArray(blackListURLStr);
    }

    private List<String> strToArray(String urlStr) {
        if (urlStr == null) {
            return new ArrayList<>(0);
        }
        String[] urlArray = urlStr.split(URL_SPLIT_PATTERN);
        List<String> urlList = new ArrayList<>();
        for (String url : urlArray) {
            url = url.trim();
            if (url.length() == 0) {
                continue;
            }
            urlList.add(url);
        }
        return urlList;
    }
}

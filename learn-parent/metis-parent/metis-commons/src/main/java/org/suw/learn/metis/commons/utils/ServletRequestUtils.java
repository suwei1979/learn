package org.suw.learn.metis.commons.utils;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zion on 4/13/15.
 */
public final class ServletRequestUtils {

    public static String getServletPath(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        if (servletPath == null || servletPath.isEmpty()) {
            Iterable<String> parts = Splitter.on(request.getContextPath()).split(request.getRequestURL());
            servletPath = Iterables.get(parts, 1);
        }
        return servletPath;
    }

    public static String getCurrentURL(HttpServletRequest request) {
        String currentURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        if (!(queryString == null || queryString.isEmpty())) {
            currentURL = currentURL + "?" + queryString;
        }
        return currentURL;
    }

    private ServletRequestUtils() {
    }
}

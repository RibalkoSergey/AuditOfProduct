package com.aop.config.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class StaticContentFilter implements Filter {

    private static final String RESOURCES_PARAMETER_NAME = "resources";
    private FilterConfig config;
    private String[] resources;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        this.resources = StringUtils.split(filterConfig.getInitParameter(RESOURCES_PARAMETER_NAME), ",");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String currentURI = ((HttpServletRequest)request).getRequestURI().toString();

        AntPathMatcher matcher = new AntPathMatcher();
        boolean isStaticContent = false;

        for (String el : resources) {
            isStaticContent = isStaticContent | matcher.match(el, currentURI);
        }

        if (isStaticContent) {
            config.getServletContext().getNamedDispatcher("default").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}

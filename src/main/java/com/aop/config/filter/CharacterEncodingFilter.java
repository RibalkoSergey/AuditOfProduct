package com.aop.config.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (this.encoding != null) {
            httpServletRequest.setCharacterEncoding(this.encoding);
            httpServletResponse.setCharacterEncoding(this.encoding);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void destroy() {

    }
}

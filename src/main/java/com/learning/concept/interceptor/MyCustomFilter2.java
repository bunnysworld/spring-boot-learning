package com.learning.concept.interceptor;

import jakarta.servlet.*;

import java.io.IOException;

public class MyCustomFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter-2 before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter-2 after");
    }
}

package com.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这个是一个实现filter的抽象类,主要是对于filter过滤器的重复操作的一些封装
 */
public abstract class FilterImplement implements Filter {
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private FilterConfig filterConfig = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        request = (HttpServletRequest) servletRequest;
        response = (HttpServletResponse) servletResponse;
        doFilter(request,response,filterChain);
    }

    public abstract void doFilter(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,FilterChain filterChain) throws IOException, ServletException;


    @Override
    public void destroy() {

    }

    public FilterConfig getFilterConfig() {
        return this.filterConfig;
    }
}

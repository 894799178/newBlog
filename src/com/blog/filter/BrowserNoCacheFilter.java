package com.blog.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 禁用浏览器缓存过滤器
 */
public class BrowserNoCacheFilter extends  FilterImplement {
    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        //禁止浏览器缓存所有动态页面
        httpServletResponse.setDateHeader("Expires",-1);
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setHeader("Pragma", "no-cache");
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}

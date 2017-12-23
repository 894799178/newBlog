package com.blog.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤器
 */
public class Encoding implements Filter {
    private String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(encoding == null){
            encoding = servletRequest.getServletContext().getInitParameter("encoding");
        }
       servletRequest.setCharacterEncoding(encoding);
       filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

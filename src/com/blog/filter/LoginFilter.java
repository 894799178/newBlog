package com.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class LoginFilter implements Filter {
    /**
     * 登录过滤器
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =  (HttpServletRequest)servletRequest;
        List list  = (List)req.getSession().getAttribute("list");
        if(list != null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

package com.blog.service;


import com.blog.dao.bottom.DataDispose;
import com.blog.dao.db.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        DataDispose dataDispose = new DataDispose();
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        String password =req.getParameter("password");
        System.out.println(name+":"+account+":"+password);
        if ("".equals(name) || "".equals(account) || "".equals(password)){
            req.getRequestDispatcher(req.getContextPath() +"/register.jsp").forward(req,resp);
            req.setAttribute("state","你的资料不能为空");
            return;
        }
        if(dataDispose.getAccountForCount(account) > 0){
            req.setAttribute("state","用户名已存在");
            req.getRequestDispatcher(req.getContextPath() +"/register.jsp").forward(req,resp);
            return;
        }
        dataDispose.addAccount(account,password);
        System.out.println(req.getContextPath());
        resp.sendRedirect(req.getContextPath()+"/index.jsp");


    }
}

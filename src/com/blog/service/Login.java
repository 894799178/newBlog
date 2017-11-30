package com.blog.service;


import com.blog.dao.bottom.LoginDataDispose;
import org.omg.CORBA.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginDataDispose ldd = new LoginDataDispose();

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        long i=ldd.getForLogin(userName,password);
        if(i>0){
            resp.sendRedirect("/index.jsp");
        }else{
            resp.sendRedirect("/login.jsp");
        }

    }
}

package com.blog.service;


import com.blog.dao.bottom.ContentDataDispose;
import com.blog.dao.bottom.LoginDataDispose;
import com.blog.domain.Content;
import org.omg.CORBA.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
            ContentDataDispose contentDataDispose = new ContentDataDispose();
            int userId =ldd.getForUserId(userName);
            List <Content> list=contentDataDispose.getContentByUserId(userId);
            HttpSession  hs = req.getSession();
            hs.setAttribute("list",list);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/login.jsp");
        }

    }


}

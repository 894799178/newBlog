package com.blog.service;

import com.blog.domain.Content;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *  查看类
 *  显示Content中具体的内容.
 */
public class Watch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // req.setCharacterEncoding("utf-8");
        int id =Integer.valueOf(req.getParameter("id")) ;
        HttpSession hs = req.getSession();
        List <Content>list =(List)hs.getAttribute("list");
        for (Content content:list) {
            //遍历list中的content类中的主要内容.
            if (content.getId() == id){
                hs.setAttribute("str",content.getContent());
                break;
            }
        }
        resp.sendRedirect(req.getContextPath() +"/content.jsp");
    }
}

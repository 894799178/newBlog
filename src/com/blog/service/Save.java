package com.blog.service;

import com.blog.dao.bottom.DataDispose;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 该类主要用于保存编辑后的文本,并写入到mysql数据库.
 */
public class Save extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataDispose contentDataDispose = new DataDispose();
        //req.setCharacterEncoding("utf-8");
        HttpSession hs = req.getSession();
        String content = req.getParameter("Content");
        String title = req.getParameter("title");
        int userId= (int)hs.getAttribute("userId");
        hs.setAttribute("str",content);
        //如果返回0表示插入失败,标题以存在或其他问题.....
        if(contentDataDispose.insertContent(userId,title,content)<1){
            req.getRequestDispatcher(req.getContextPath()+"/edit.jsp").forward(req,resp);
        }
        resp.sendRedirect(req.getContextPath() +"/content.jsp");
    }
}

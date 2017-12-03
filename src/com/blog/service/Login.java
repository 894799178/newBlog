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
import java.util.ArrayList;
import java.util.List;

/**
 * 登录类.
 * 该类,
 */
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDataDispose ldd = null;
        long i= 0;
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(userName+":"+password);
        if(userName != null || password != null){
            ldd = new LoginDataDispose();
            i= ldd.getForLogin(userName,password);
        }
        //数据库教返回的值大于0 表示存在该帐号密码
        if(i>0){
            int userId =ldd.getForUserId(userName);
            List briefContents = new ArrayList();
            HttpSession hs = req.getSession();
            //设置session的时限
            hs.setMaxInactiveInterval(3600);
            ContentDataDispose contentDataDispose = new ContentDataDispose();
            hs.setAttribute("userId",userId);
            List <Content> list=contentDataDispose.getContentByUserId(userId);
            int size = list.size();
            //取到对象的博客,主要内容进行切割成简要内容.
           for (int i1 =0;i1<size;i1++){
               String str = list.get(i1).getContent();
                if(str.length()>130){
                    str=str.substring(0,130);
                }
               briefContents.add(str);
           }
            //将该登录用户的所有博客信息取出并存储到session的list字段中,
            //briefContents字段中存储的是对于该登录用的简要内容.
            hs.setAttribute("list",list);
            hs.setAttribute("briefContents",briefContents);
            req.getRequestDispatcher(req.getContextPath()+ "/index.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req,resp);
        }

    }


}

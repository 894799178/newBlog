package com.blog.filter;

import com.blog.dao.bottom.DataDispose;
import com.blog.domain.Content;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadContent extends FilterImplement {
    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session= httpServletRequest.getSession();
        List list=  (List)session.getAttribute("list");
        if(list != null){
            int userId =(int)session.getAttribute("userId");
            DataDispose dataDispose = new DataDispose();
            List <Content> contentList  =  dataDispose.getContentByUserId(userId);
            //如果session 中存储的博客数据的长度和数据库中博客数据的长度不一致则重新存储数据.
            // 有很大的优化空间,以及存在用户删除添加后导致数据大小和数据库大小一致的情况导致无法执行的bug.
            if(list.size() != contentList.size()) {
                List briefContents = new ArrayList();
                //切割主要内容
                briefContents=dataDispose.inciseContent(contentList);
                session.setAttribute("list",contentList);
                session.setAttribute("briefContents",briefContents);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}

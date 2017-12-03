package com.blog.dao.bottom;

import com.blog.dao.db.DAO;
import com.blog.domain.Content;

import java.util.Calendar;
import java.util.List;

public class ContentDataDispose {

    DAO dao = new DAO();

    public int insertContent(int userId,String title,String content) {
        Calendar now = Calendar.getInstance();
        String  date = String.valueOf((now.get(Calendar.MONTH) + 1));
        date += "-" + String.valueOf(now.get(Calendar.DAY_OF_MONTH)) ;
        String sql = "insert into  contenttable values(?,?,?,?,?)";
        return dao.singleInsert(sql,0,userId,title,content,date);
    }
    /**
     * 根据 id 号获取对应的数据的标题,不存在标题返回null
     * @param id
     * @return
     */
    public String getTitle(int id) {

        String sql = "select title from contenttable where id = ?";
        List list = dao.getForValue(sql, id);
        if (list != null) {
            return (String) list.get(0);
        }
        return null;
    }
    /**
     * 根据user_id获取所有的该用户的博客数据.
     * @param user_id
     * @return
     */
    public List<Content> getContentByUserId(int user_id) {
        String sql = "select id,title,content,monthday from contenttable where user_id = ? limit 5";
        List<Content> list = dao.getForList(sql, Content.class, user_id);
        return list;
    }
    /**
     * 根据id 获取对应的数据中的博客内容,不存在返回null
     * @param id
     * @return
     */
    public String getContent(int id) {
        String sql = "select content from contenttable where id = ?";
        List list = dao.getForValue(sql, id);
        if (list != null) {
            return (String) list.get(0);
        }
        return null;
    }
}

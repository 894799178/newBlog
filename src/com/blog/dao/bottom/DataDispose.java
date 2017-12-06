package com.blog.dao.bottom;

import com.blog.dao.db.DAO;
import com.blog.domain.Content;
import com.blog.domain.UserLogin;

import java.util.Calendar;
import java.util.List;

/**
 * 提供给上层login类的功能,底层由Dao层提供支持
 */
public class DataDispose {
    /**
     *处理登录.返回数据库中匹配的帐号密码数量
     * @param username
     * @param password
     * @return
     */
    DAO dao = new DAO();
    public long getForLogin(String username,String password){
        DAO <UserLogin>dao = new DAO<UserLogin>();
        String sql = "select count(*) from userlogintable where username = ? and password  = ?";
        //额..获取一个数量
        Long i = (Long)dao.getForValue(sql,username,password).toArray()[0];
        return i;
    }
    /**
     * 获取UserId 通过用户的帐号获取
     * @param username
     * @return
     */
    public int getForUserId(String username){
        DAO <UserLogin>dao = new DAO<UserLogin>();
        String sql = "select id from userlogintable where username = ? ";
        int i = (int)dao.getForValue(sql,username).toArray()[0];
        return i;
    }

    /**
     * 主要获取存放用户帐号密码中的 帐号是否存在.
     * @param account
     * @return
     */
    public long  getAccountForCount(String account){
        String sql = "select count(*) from userlogintable where username = ?";
        return  (long)dao.getForValue(sql,account).get(0);
    }


    public int addAccount(String account,String password){
        String sql = "insert into userlogintable (username,password) values(?,?)";
        return  dao.singleInsert(sql,account,password);
    }


    /**
     *  添加主要内容到博客
     * @param userId
     * @param title
     * @param content
     * @return
     */
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
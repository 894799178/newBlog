package com.blog.dao.bottom;

import com.blog.dao.db.DAO;
import com.blog.domain.UserLogin;

/**
 * 提供给上层login类的功能,底层由Dao层提供支持
 */
public class LoginDataDispose {
    /**
     *处理登录.返回数据库中匹配的帐号密码数量
     * @param username
     * @param password
     * @return
     */
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

}
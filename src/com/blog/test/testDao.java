package com.blog.test;

import com.blog.dao.db.DAO;
import com.blog.domain.User;
import org.junit.Test;

import java.util.List;

public class testDao  extends DAO{


    @Test
    public void test(){
        String sql = "select id,name,age,sex,phone from user";
       System.out.println( super.getForList(sql,User.class));
        sql = "select id,name,age,sex,phone from user where id = ?";
        System.out.println( super.get(sql,User.class,1));
        sql = "select max(age) from user ";
        System.out.println( super.getForValue(sql));



    }
}

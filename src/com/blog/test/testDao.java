package com.blog.test;

import com.blog.dao.db.DAO;
import org.junit.Test;

import java.util.List;

public class testDao  extends DAO{


    @Test
    public void test(){
        String sql = "select id,name,age,sex,phone from user";
        super.getForList(sql);
        sql = "select id,name,age,sex,phone from user where id = ?";
        super.get(sql,1);
        sql = "select max(age) from user ";
        super.getForValue(sql);

    }
}

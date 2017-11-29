package com.blog.dao.db;

import com.blog.domain.user;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DataDisposeInterfaceImp extends DAO<user> implements  DataDisposeInterface{


    @Override
    public List getAll() {
        String sql = "select id,name,age,sex,phone,ddate from user";
        List<user> list  = getForList(sql);
        return list;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Object getByName(String name) {
        return null;
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int insert(Object obj) {
        return 0;
    }
}

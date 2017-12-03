package com.blog.dao.db;

import com.blog.domain.User;

import java.util.List;

public class DataDisposeInterfaceImp extends DAO<User> implements  DataDisposeInterface{

    @Override
    public List getAll() {
        String sql = "select id,name,age,sex,phone from user";
        List<User> list  = getForList(sql,User.class);
        return list;
    }
    @Override
    public Object getById(int id) {
        String sql = "select id,name,age,sex,phone from user where id = ?";
        return get(sql,User.class,id);
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

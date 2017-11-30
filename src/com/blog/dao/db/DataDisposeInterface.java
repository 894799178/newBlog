package com.blog.dao.db;

import java.util.List;

/**
 * 处理数据的接口
 * @param <T>
 */

interface DataDisposeInterface<T> {
    public List<T> getAll();
    public T getById(int id);
    public T getByName(String name);
    public int update(T obj);
    public int deleteById(int id);
    public int insert(T obj);

}

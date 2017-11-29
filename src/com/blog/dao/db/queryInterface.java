package com.blog.dao.db;

import java.sql.Connection;
import java.util.List;

/**
 * 数据处理接口
 * @param <T>
 */
interface DataDisposeInterface<T>  {
    public List<T> getAll();
    public T getById(int id);
    public T getByName(String name);


}

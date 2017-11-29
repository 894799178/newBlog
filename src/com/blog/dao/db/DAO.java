package com.blog.dao.db;

import com.blog.domain.user;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T>  {

     public <T>List getForList(String sql){
        Connection conn = null;
        List <Map<String,Object>> list =null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            list = retuenResult(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(conn);
        }

        return list;
    }

    /**
     * 获取一组数据
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public  <T>List get(String sql,Object ... args){
        Connection conn = null;
        List <Map<String,Object>> list = null;
        try{
            conn = DBUtil.getConnection();
            PreparedStatement ps=fillPlaceholder(conn.prepareStatement(sql),args);
            list = retuenResult(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(conn);
        }
        System.out.println(list.get(0));
        return list;
    }

    /**
     * 获取某些单一的数据...
     * @param sql
     * @param args 填充占位符的数据
     * @return 返回一个对象
     */
    public  Object getForValue(String sql,Object ... args){
        Connection conn = null;
        List <Map<String,Object>> list = null;
        try{
            conn = DBUtil.getConnection();
            PreparedStatement ps=fillPlaceholder(conn.prepareStatement(sql),args);
             list =retuenResult(ps);
             ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(conn);
        }
        //额....先获取到list中的map然后通过values方法转换成Collection,在调用他的toArray方法.
        return list.get(0).values().toArray();
    }

    /**
     * 填充占位符
     * @param ps 未填充占位符的PreparedStatement
     * @param objs 填充占位符的值集合
     * @return 返回填充完占位符的PreparedStatement
     * @throws SQLException
     */
    private PreparedStatement fillPlaceholder(PreparedStatement ps,Object []objs) throws SQLException {
        int i = 1;
        for(Object obj: objs){
             ps.setObject(i,obj);
             i++;
        }
        return ps;
    }

    /**
     * 传入PreparedStatement输出结果集合
     * @param ps  传入PreparedStatement
     * @param <T>
     * @return 一个 list 集合 这个集合包含一个map键值对
     * @throws SQLException
     */
    private <T>List retuenResult(PreparedStatement ps) throws SQLException {
        List <Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        //执行查询
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData resultSetMetaData =   rs.getMetaData();
        //遍历结果集存储结果到list中
        while(rs.next()){
            Map map = new HashMap();
            int col = resultSetMetaData.getColumnCount();
            for(int i = 1; i<= col;i++ ){
                map.put(resultSetMetaData.getColumnName(i),rs.getObject(i));
            }
            list.add(map);
        }
        return list;
    }

}

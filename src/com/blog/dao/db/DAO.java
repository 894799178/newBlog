package com.blog.dao.db;

import com.blog.domain.User;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO<T>  {
    /**
     * 获取一组或多组数据
     * @param sql
     * @param <T>
     * @return
     */
     public <T>List getForList(String sql,Class<T> clazz){
        Connection conn = null;
        List <User> list =null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);

            list = retuenForUserResult(ps,clazz);
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(conn);
        }
    System.out.println(list);
        return list;
    }

    /**
     * 获得一组数据
     * @param sql
     * @param clazz
     * @param args
     * @return
     */
    public  T get(String sql,Class<T> clazz,Object ... args){
        Connection conn = null;
        List <T> list = null;
        try{
            conn = DBUtil.getConnection();
            PreparedStatement ps=fillPlaceholder(conn.prepareStatement(sql),args);
            User user = new User();
            list = retuenForUserResult(ps,user.getClass());
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(conn);
        }
        System.out.println(list.get(0));
        return list.get(0);
    }

    /**
     * 获取某些单一的数据...
     * @param sql
     * @param args 填充占位符的数据
     * @return 返回一个对象
     * 重写!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *
     */

    public  Object getForValue(String sql,Class clazz,Object ... args){
        Connection conn = null;
        List <T>list = null;
        try{
            conn = DBUtil.getConnection();
            PreparedStatement ps=fillPlaceholder(conn.prepareStatement(sql),args);
         //   list=retuenForUserResult(ps,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(conn);
        }
        System.out.println(list);
        //list.get(0).values().toArray();
        //额....先获取到list中的map然后通过values方法转换成Collection,在调用他的toArray方法.
        return null;
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
    private <T>List retuenForUserResult(PreparedStatement ps, Class<T> clazz) throws SQLException,Exception {
        List <Object> list = new ArrayList<Object>();
        //执行查询
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd =   rs.getMetaData();
        int col = rsmd.getColumnCount();
        //
        while(rs.next()){
            Object obj=makeClass(clazz);
            Class classs =  obj.getClass();
            //遍历每一组的当前列的数据值
            for(int i =1;i<=col;i++ ) {
                Object objTemp =rs.getObject(i);
                String str = firstChangeCapitalize(rsmd.getColumnName(i));
                //使用反射获取对应类的方法并执行
                if (objTemp != null) {
                    Method m = classs.getMethod("set" + str, objTemp.getClass());
                    m.invoke(obj, objTemp);
                }
            }
            list.add(obj);
          //  list.add(user);
        }
        return list;
    }

    /**
     * 将字符串的首字母变大写
     * @param str
     * @return
     */
    private String  firstChangeCapitalize(String str){
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }
    private Object makeClass(Class clazz) throws Exception{
        Object obj = clazz.newInstance();
        return obj;
    }

}

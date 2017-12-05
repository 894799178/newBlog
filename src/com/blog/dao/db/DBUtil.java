package com.blog.dao.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 提供连接数据库,释放数据库等功能实现,
 */
public class DBUtil {
        private static DataSource dataSource = null;
        static{
                dataSource =   new ComboPooledDataSource("Blog");
        }
        /**
         *  获取一个Connection实例
         * @return
         * @throws SQLException
         */
        public static  Connection getConnection() throws SQLException {

                return dataSource.getConnection();
        }
        public static void releaseConnection(Connection connection){
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

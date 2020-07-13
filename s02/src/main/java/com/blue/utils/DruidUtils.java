package com.blue.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {

    private static DataSource dataSource;
    static {

        Properties pro=new Properties();
        try {
            pro.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取连接�?
    public static Connection getConnection() throws SQLException {

        return  dataSource.getConnection();
    }
    // 获取数据�?
    public static DataSource getDateSource(){

        return dataSource;
    }
    // 释放资源
    public static void close(Statement state, Connection conn){

        if(state!=null){

            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){

            try {
                conn.close();   // 归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 关闭资源的重载方�?
    public static void close(ResultSet set, Statement state, Connection conn){

        close(state,conn);
        if(set!=null){

            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

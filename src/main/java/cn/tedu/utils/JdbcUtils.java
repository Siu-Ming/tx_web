package cn.tedu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 拓薪教育：樱木老师
 * 腾讯课堂搜索：拓薪教育
 * 腾讯课堂直播间地址：https://ke.qq.com/course/149432
 * 加入QQ群领取免费资料和视频：QQ群号 344379612
 * JDBC的工具类，使用连接池获取到连接
 */
public class JdbcUtils {

    // 连接池对象
    private static DataSource DATA_SOURCE;

    static{
        // 加载属性文件
        Properties pro = new Properties();
        try {
            // 加载属性文件
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 创建连接池对象
            DATA_SOURCE = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从连接池中获取连接，返回。
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     * @param conn
     * @param stmt
     */
    public static void close(Connection conn, Statement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

package com.atcps.utils;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//连接数据库工具类
public class JdbcUtils {

    private static DruidDataSource dataSource;//定义一个德鲁伊变量池的一个静态变量
    private static ThreadLocal<Connection> conns =new ThreadLocal<Connection>();//有新的业务进程
    //有新的进程，把进程放到ThreadLocal中

    static{

        try {
            Properties properties = new Properties();//读取jdbc属性配置文件
            //将jdbc中的文件配置成一个流
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println("dataSource： " + dataSource.getConnectCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /*
     * 获取数据库连接池中的连接
     * return 如果返回null，说明连接失败*/

    public static Connection getConnection(){
        Connection conn = conns.get();
        if(conn==null){
            try {
                conn = dataSource.getConnection();//从数据库连接池中获取连接
                conns.set(conn);//将连接放入ThreadLocal对象中
                conn.setAutoCommit(false);//设置手动管理事务
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public static void commitAndClose(){
        Connection connection = conns.get();
        if(connection!=null){
            try {
                connection.commit();//先提交
            } catch (SQLException throwables) {
                throwables.printStackTrace();//提交有问题
            }finally {
                try {
                    connection.close();//后关闭事务
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();//一定要执行remove操作，否则会出错，因为tomcat服务器底层使用线程池
    }


    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if(connection!=null){
            try {
                connection.commit();//先回滚
            } catch (SQLException throwables) {
                throwables.printStackTrace();//提交有问题
            }finally {
                try {
                    connection.close();//后关闭事务
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();//一定要执行remove操作，否则会出错，因为tomcat服务器底层使用线程池
    }
}

package com.atcps.Dao.impl;

import com.atcps.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//基础类 Dao层 作用是处理Dao层与数据库之间的数据交互
public  abstract class BaseDao {

    //通过DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    //update() 方法用来执行： insert/update/delete等语句
    //return 返回-1 说明执行失败，返回其他表示影响行数
    public int update(String sql , Object...args){
        Connection connection = JdbcUtils.getConnection(); // 获得数据库的配置
        try {
            System.out.println("connction： " + connection);
            return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw  new RuntimeException(throwables);
        }
    }

    /*
    * 查询返回一个javaBean的sql语句
    *
    */

    public <T> T queryForOne(Class<T> type , String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /*
    *
    * 查询返回多个JavaBean的sql语句*/

    public <T> List<T> queryforList(Class<T> type ,String sql ,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type) , args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }


}

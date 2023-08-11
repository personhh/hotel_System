package com.atcps.Dao.impl;

import com.atcps.Dao.UserDao;
import com.atcps.Entity.User;

//接口UserDao实现类
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int saveUser(User user) {
        String sql = "insert into hotel_user(username,password) values(?,?)";//sql 语句
        return update(sql,user.getUsername(),user.getPassword());
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username ,password from hotel_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id , username , password from hotel_user where username = ? and password = ?";
        return queryForOne(User.class, sql ,username ,password);
    }

}

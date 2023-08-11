package com.atcps.Dao;

import com.atcps.Entity.User;

//UserDao接口类
public interface UserDao {
    /*
    * 存储用户基本信息*/

    public int saveUser(User user);

    /*
    根据用户用户名查找用户信息
    * */

    public User queryUserByUsername(String username);


    //根据用户名和密码查询用户
    public User queryUserByUsernameAndPassword(String username , String password);


}

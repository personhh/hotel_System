package com.atcps.service;

import com.atcps.Entity.User;

public interface UserService {

    //注册用户
    public void registUser(User user);

    //根据姓名查找用户信息

    public boolean existUsername(String username);

    //根据姓名和密码检查登录

    public boolean existUserByUsernameAndPassword(String username ,String password);

}

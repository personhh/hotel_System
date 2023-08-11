package com.atcps.test;

import com.atcps.Dao.UserDao;
import com.atcps.Dao.impl.UserDaoImpl;
import com.atcps.Entity.User;
import com.atcps.service.UserService;
import com.atcps.service.impl.UserServiceImpl;
import org.junit.Test;

public class testUserDaoImpl {

    private UserDao userDao = new UserDaoImpl();
    private UserService userService = new UserServiceImpl();

    @Test
    public void saveUser(){
        userDao.saveUser(new User("admin" , "12345"));
        System.out.println("数据保存成功");
    }

    @Test
    public void existUsername(){
        System.out.println(userDao.queryUserByUsername("adm"));
        System.out.println(userService.existUsername("admin"));
        System.out.println("根据名字查找用户");
    }

    @Test
    public void existUserByUsernameAndPassword(){
        System.out.println(userService.existUserByUsernameAndPassword("admin","123456"));
        System.out.println(userService.existUserByUsernameAndPassword("admin","12345"));
    }
}

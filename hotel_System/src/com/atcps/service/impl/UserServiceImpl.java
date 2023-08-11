package com.atcps.service.impl;

import com.atcps.Dao.UserDao;
import com.atcps.Dao.impl.UserDaoImpl;
import com.atcps.Entity.User;
import com.atcps.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existUsername(String username){
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean existUserByUsernameAndPassword(String username, String password) {
        if(userDao.queryUserByUsernameAndPassword(username,password) == null){
            return false;
        }
        return true;
    }

}

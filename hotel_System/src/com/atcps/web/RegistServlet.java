package com.atcps.web;

import com.atcps.Dao.impl.BaseDao;
import com.atcps.Entity.User;
import com.atcps.service.UserService;
import com.atcps.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!userService.existUsername(username)) {
            //如果用户名不存在，则可以注册
            userService.registUser(new User(null, username, password));
            req.getRequestDispatcher("/page/user/userLogin.jsp").forward(req, resp);
            System.out.println("用户注册成功" );
        }else{
            System.out.println("用户名"+ username +"已存在");
            req.setAttribute("msg" , "用户已存在");
            req.getRequestDispatcher("/page/user/userRegist.jsp").forward(req,resp);
        }
    }
}

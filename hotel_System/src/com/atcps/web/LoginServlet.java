package com.atcps.web;

import com.atcps.Entity.User;
import com.atcps.service.UserService;
import com.atcps.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登录业务服务处理
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet类调用了doPost方法");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(null , username , password);

        if(userService.existUserByUsernameAndPassword(username,password)){
            //如果能查到的话 进行登录
            req.getSession().setAttribute("user" , user);
            req.getSession().setAttribute("username" , username );
            req.getRequestDispatcher("/page/user/userLogin_Success.jsp").forward(req, resp);
            System.out.println("用户"+ username + "登录成功");
        }else{
            //登录不成功
            req.setAttribute("msg" , "用户名或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/page/user/userLogin.jsp").forward(req,resp);
            System.out.println("用户" + username + "登录失败");
        }

    }
}

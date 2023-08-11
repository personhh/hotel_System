package com.atcps.web;

import com.atcps.service.UserService;
import com.atcps.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用户业务处理
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost");
        super.doPost(req, resp);
    }

    protected void UserMove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注销
        //1.销毁Session中用户登录的信息（或注销Session对象）
        req.getSession().invalidate();
        //2.重定向到登录页面

//        resp.sendRedirect(req.getContextPath());
//        System.out.println(req.getContextPath());
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }



}

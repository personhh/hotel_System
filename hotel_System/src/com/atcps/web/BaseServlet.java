package com.atcps.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//解决请求时乱码问题
        resp.setContentType("text/html;charset=UTF-8");//解决响应时乱码

        String action = req.getParameter("action");//获得请求参数的值
        System.out.println(action);//输出请求参数的值

        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);//获得该方法
            System.out.println(method);//输出所获得的method全称
            method.invoke(this,req,resp);//调用刚获得的方法
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("你调用getDeclaredMethod方法");
        }

    }
}

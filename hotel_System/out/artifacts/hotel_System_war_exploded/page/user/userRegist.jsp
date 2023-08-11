<%--
  Created by IntelliJ IDEA.
  User: 丛培圣
  Date: 2023/8/4
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册页面</title>
    <link rel="stylesheet" type="text/css" href="../../statics/css/style.css"/>
    <script type="text/javascript" src="../../statics/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">

        $(function (){
            $("#sub_btn").click(function (){//给注册提交按钮绑定事件

                //检查用户名字的正确性
                var username = $("#username").val();//获得input中name值为username的文本值
                var usernamepott = /^\w{3,10}$/;//设置一个正确的的username 内容是数字，字母或者下划线的组合
                //进行比较
                if(!usernamepott.test(username)){
                   $("span.errorMsg").text("用户不合法，必须是数字，字母或者下划线的3到10个")
                    return false;
                }

                //检查用户密码的正确性
                var password = $("#password").val();
                var passwordpott=/^\w{3,10}$/;
                if(!passwordpott.test(password)){
                    $("span.errorMsg").text("密码不合法")
                    return false;
                }

                //检验两次密码不正确
                var infirmpassword = $("#infimpassword").val();
                var infrimpasswordpott = $("#password").val();
                if(infrimpasswordpott!=infirmpassword){
                    $("span.errorMsg").text("两次密码不一致");
                    return false;
                }

                $("span.errorMsg").text("")
            })
        })
    </script>
</head>
<body>
<h1>用户注册页面</h1>
<fieldset>
    <legend>请注册</legend>
    <span class="errorMsg" style="color: red">${requestScope.msg}</span>
    <form action="/registServlet" method="post">
                <%--注册用户名--%>
                <label>用户名</label>  <input type="text" name="username" id="username"/>
            <br/>
            <br/>
                <%--注册密码--%>
                <label>密码</label>    <input type="password" name="password" id="password">
                    <br/>
                    <br/>
                <%--确认密码--%>
                <label>确认密码</label>   <input type="password" name="infimpassword" id="infimpassword">
                <br/>
                <br/>
                    <input type="submit" value="登录" id="sub_btn"/>
                    <input type="reset" value="重置"/>
    </form>
</fieldset>
</body>
</html>

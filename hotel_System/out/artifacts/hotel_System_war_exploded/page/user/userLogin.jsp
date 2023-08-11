<%--
  Created by IntelliJ IDEA.
  User: 丛培圣
  Date: 2023/8/4
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="../../statics/css/style.css"/>
</head>
<body>
<div  id="title" >请登录用户信息</div>

     <div>
         <span style="color: red" >
             ${empty requestScope.msg ? "请输入用户名和密码" :  requestScope.msg}
         </span>
     </div>
         <br/>
    <form action="/loginServlet" method="post">
        <input type="hidden" name = "action" value="login"/>
            <%--登录用户名--%>
            <label>用户名</label>  <input type="text" name="username"/>
       <br/>
       <br/>
            <%--登录密码--%>
            <label>密码</label>    <input type="password" name="password">
      <br/>
      <br/>
            <%--验证码--%>
            <label>验证码输入</label>   <input type="text" name="checkCode"/>
        <br/>
        <br/>
                <input type="submit" value="登录"/>
   </form>
</body>
</html>

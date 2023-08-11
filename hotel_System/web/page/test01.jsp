<%--
  Created by IntelliJ IDEA.
  User: 丛培圣
  Date: 2023/8/5
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="../statics/script/jquery-1.7.2.js"></script>
    <script  type="text/javascript">
        $(function (){
            $("#okok").click(function (){
                alert("okok");
            })
        })
    </script>
</head>
<body>
<form action="/test01" method="post">
    <label>名字</label>
    <input type="text" name="username"/>
    <input type="submit" value="提交"/>
</form>


<form action="" method="post">
    <label>名字</label>
    <input type="text" name="username"/>
    <input type="submit" value="提交" id="okok"/>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 丛培圣
  Date: 2023/8/4
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>松培酒店系统</title>
    <link rel="stylesheet" type="text/css" href="../../statics/css/style.css"/>
</head>
<body>
<h1>欢迎来到酒店管理系统的页面</h1>

<%--首部--%>
<div id= "header" align="right">
    <%--放商标图片--%>
    <img src=""/>
    <%--设置一些标签--%>
    <span class="title_word">松培酒店</span>

    <%--布局登录设置购物车搜索等--%>
    <div>
        <c:if test = "${empty sessionScope.username}">
            <a class="LoginAndRegist" href="../../page/user/userLogin.jsp">登录</a>
            ||
            <a class="LoginAndRegist" href="../../page/user/userRegist.jsp">注册</a>
        </c:if>

        <c:if test = "${ not empty sessionScope.username}">
            <span>欢迎<span style="color: red">${sessionScope.username}</span>的到来</span>
            <a href="/userServlet?action=UserMove">注销账户</a>
        </c:if>
        <a href="../../page/shoppingCar.jsp">购物车</a>
        <a href="/hotelServlet?action=list">酒店管理</a>
        <div>
            <form aciton="#" method="post">
                <input type="text" name="checkKeyWord"/>
                <input type="submit" value="搜索"/>
            </form>
        </div>
    </div>
    <hr/>


</div>

<%--中间部分--%>
<div id="main" >
    <div id="main_header" style="overflow-x: auto">
        <c:forEach items = "${requestScope.hotels}" var="hotel">
            <div class="hotel_list" style="height: 400px">
                <div class="img_hotel">
                        <%--放酒店的照片--%>
                    <img class="hotel_img_place" src="${hotel.hotel_photo}">
                </div>
                <div class="hotel_information">
                    <div class="hotel_name">
                        <span class="sp1">酒店名称:</span>
                        <span class="sp2">${hotel.hotel_name}</span>
                    </div>
                    <div class="hotel_price">
                        <span class="sp1">价格(元/日):</span>
                        <span class="sp2">${hotel.hotel_price}</span>
                    </div>
                    <div class="hotel_location">
                        <span class="sp1">酒店位置:</span>
                        <span class="sp2">${hotel.hotel_location}</span>
                    </div>
                    <div class="hotel_add">
                        <button hotelId="${hotel.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>
</div>

<%--尾部--%>
<div id="footer">
    <div align="center">松培酒店管理集团有限公司.@songpei.com</div>
    <div style="color: goldenrod" align="center"><h2>关于我们</h2></div>
    <div >请关注我们 添加联系方式如下：</div>
    <p>手机联系方式： 159XXXXXX79</p>
</div>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 丛培圣
  Date: 2023/8/8
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>酒店列表查看</title>
    <%@include file="/page/common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="../../statics/css/style.css"/>
    <script type="text/javascript" src="../../statics/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function (){
            $("a.deletehotel").click(function (){
                return confirm("你确定删除：" + $(this).parent().parent().find("td:first").text() + "吗？");
                return false;
            })
        })
    </script>
</head>
<body>

 <div id="header_hotelListManager">
    <span class="wel_word_hotelListManager">酒店管理系统</span>
 </div>


<div id="main_hotelListManager">
    <table cellpadding="10">
        <colgroup span = "6"></colgroup>
        <tr>
            <td>酒店名称</td>
            <td>价格(元/日)</td>
            <td>地址</td>
<%--            <td>销量</td>--%>
<%--            <td>库存</td>--%>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.hotels}" var="hotel">
            <tr>
                <td>${hotel.hotel_name}</td>
                <td>${hotel.hotel_price}</td>
                <td>${hotel.hotel_location}</td>
                <td><a href="/hotelServlet?action=getHotel&id=${hotel.id}">修改</a></td>
                <td><a class="deletehotel" href="/hotelServlet?action=delete&id=${hotel.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="/hotelServlet?action=getHotel">添加酒店</a></td>
        </tr>
    </table>

</div>
</body>
</html>

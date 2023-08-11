<%--
  Created by IntelliJ IDEA.
  User: 丛培圣
  Date: 2023/8/10
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>酒店数据更改系统</title>
    <link rel="stylesheet" type="text/css" href="../../statics/css/style.css"/>
</head>
<body>
<div id="header_hotelListManager">
    <span class="wel_word_hotelListManager">编辑图书</span>
</div>

<div id="main_hotelListManager">
    <form action="/hotelServlet" method="get">
        <input type="hidden" name="action" value="${empty param.id ? "add" : "update"}"/>
        <input type="hidden" name="id" value="${requestScope.Listhotel.id}"/>
        <table>
            <tr>
                <td>酒店名称</td>
                <td>价格(元/日)</td>
                <td>地址</td>
                <td>图片地址（仅管理员）</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="hotel_name" type="text" value="${requestScope.Listhotel.hotel_name}"/></td>
                <td><input name="hotel_price" type="text" value="${requestScope.Listhotel.hotel_price}"/></td>
                <td><input name="hotel_location" type="text" value="${requestScope.Listhotel.hotel_location}"/></td>
                <td><input name="hotel_photo" type="text" value="${requestScope.Listhotel.hotel_photo}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>
</body>
</html>

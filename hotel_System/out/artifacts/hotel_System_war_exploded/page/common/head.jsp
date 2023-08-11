<%--
  Created by IntelliJ IDEA.
  User: 丛培圣
  Date: 2023/8/10
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath =request.getScheme()+"://"+request.getServerName()
            +":" + request.getServerPort() + request.getContextPath()+"/";
    pageContext.setAttribute("basePath",basePath);
%>
<%=basePath%>
<base href="<%=basePath%>">


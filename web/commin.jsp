<%--
  Created by IntelliJ IDEA.
  User: zd
  Date: 2020/6/10
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">图书网后台管理系统</h3>
<p style="margin-left: 80%">欢迎：${user.AName} <a href="/user?method=logout">登出</a></p>
<div align="center" style="background-color: darkorange">
    <p><span><a href="/houtai.jsp">首页</a></span><span style="margin-left: 50px"><a href="/category.jsp">图书分类管理</a></span><span style="margin-left: 50px"><a href="product.jsp">图书管理</a></span><span style="margin-left: 50px">购书订单</span></p>
</div>
</body>
</html>

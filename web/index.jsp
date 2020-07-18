<%--
  Created by IntelliJ IDEA.
  User: zd
  Date: 2020/6/10
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3 align="center">图书网后台管理系统</h3>
  <div align="center">
      <form action="user">
          <label>账号</label> <input type="text" name="ALoginID" value="${cookie.get("TU").value.split("&")[0]}"><br>
          <label>密码</label><input type="password" name="ALoginPSW" value="${cookie.get("TU").value.split("&")[1]}"><br>
          <input type="checkbox" name="autoLog" value="on"><span>记住用户名和密码</span><br>
          <input type="hidden" name="method" value="login">
          <input type="submit" value="登陆"><br>
      </form>
  </div>

  </body>
</html>

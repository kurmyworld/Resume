<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>登陆</title>
  </head>
  <body>
  	<h1>${requestScope.msg }</h1>
    <form class="" action="<c:url value="/Login" />" method="post">
      邮　箱：<input type="text" required="required" id="email" name="email" placeholder="请输入邮箱" value="${sessionScope.user.email}"/>
      </br>
      密　码：<input type="password" required="required" id="userpswd" name="userpswd" placeholder="请输入密码" value="${sessionScope.user.userpswd}"/>
      </br>
      <input type="submit" value="登陆"/>
    </form>
  </body>
</html>

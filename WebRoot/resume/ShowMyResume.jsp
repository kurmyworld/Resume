<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>MyResume</title>
  </head>
  <body>
    <h1>${requestScope.msg }</h1>
    ${sessionScope.user }</br>
    ${sessionScope.resume }
  </body>
</html>

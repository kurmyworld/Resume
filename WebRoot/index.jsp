<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet" type="text/css" />
    
    <link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>" rel='stylesheet' type="text/css"/>
    <title>My Resume</title>
  </head>
  
  <body>
  	<div class="container">
  	
  		
  		
  	</div>
  	<!--
  	[bootstrap js] 
	<script src="<c:url value="/assets/bootstrap/js/jquery.js"/>"></script>
	<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
  	 -->
  </body>
</html>

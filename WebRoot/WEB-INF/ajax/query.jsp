<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:forEach var="user" items="${users }">
	<tr id="${user.username}">
		<td>${user.email}</td>
		<td>${user.username}</td>
		<td><a class="btn btn-xs btn-primary"
			href='<c:url value="/Share?u=${user.username }"/>' target="_blank">查看</a>
			<a class="btn btn-xs btn-danger" onclick='del("${user.uid}","${user.username}");'>删除</a></td>
	</tr>
</c:forEach>

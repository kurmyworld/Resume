<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>更改密码</title>
<link href='<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>'
	rel='stylesheet' type='text/css' />
<script src='<c:url value="/assets/js/MyBase.js"/>'></script>
</head>
<body>
	<div class="container">
		<div style="height:120px;"></div>
		<div class="col-lg-6 col-lg-offset-3">
			<div class="row">
				<div col-sm-12>
					<c:if test="${not empty msg}">
						<c:out value="
							<div class='alert alert-info'>${msg}</div>
						" escapeXml="false"/>
					</c:if>
				</div>
				<form atction='<c:url value="/user/ModifyPassword" />' method="post" onsubmit="return checkSubmit('newpswd','newpswd2');">
					<div class="form-group">
						<label for="oldpswd">旧密码</label> <input class="form-control"
							type="password" name="oldpswd"
							required="required" />
					</div>
					<div class="form-group">
						<label for="newpswd">新密码</label> <input class="form-control"
							type="password" name="newpswd" id="newpswd"
							required="required" />
					</div>
					<div class="form-group">
						<label for="newpswd2">确认新密码</label> <input class="form-control"
							type="password" name="newpswd2" id="newpswd2"
							required="required" />
					</div>
					<div class="form-group">
						<button class="btn btn-success col-sm-12 col-md-5">更改密码</button>
						<a class="btn btn-primary col-sm-12 col-md-5   col-md-offset-2" onclick="javascript:document.location='<c:url value="/resume/MyResume"/>';">返回首页</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src='<c:url value="/assets/bootstrap/js/jquery.js"/>'></script>
	<script src='<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>'></script>
	
</body>
</html>

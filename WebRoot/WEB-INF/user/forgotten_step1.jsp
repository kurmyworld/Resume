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
<meta charset="utf-8">
<title>忘记密码</title>
<link href='<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="container">
		<div style="height:120px;"></div>
		<form action='<c:url value="/user?method=forgotten_step1"/>' method="post">
			<div class="row">
				<div
					class='col-sm-12 col-md-6 col-lg-6 col-md-offset-3 col-lg-offset-3'>
					<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<input type="email" name="email" class="form-control"
							placeholder="请输入您的邮箱" required="required" />
					</div>
					<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
						<button
							class="btn btn-success col-xs-12 col-sm-12 col-md-12 col-lg-12 ">找回密码</button>
					</div>
					<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
						<a onclick="javascript:document.location='<c:url value="/resume?method=myResume"/>';"
							class="btn btn-primary col-xs-12 col-sm-12 col-md-12 col-lg-12 ">返回首页</a>
					</div>
					
				</div>
			</div>
		</form>
	</div>
	<script src='<c:url value="/assets/bootstrap/js/jquery.js" />'></script>
	<script src='<c:url value="/assets/bootstrap/js/bootstrap.min.js" />'></script>
</body>

</html>

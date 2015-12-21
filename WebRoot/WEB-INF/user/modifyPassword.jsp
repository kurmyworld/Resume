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
</head>
<body>
	<div class="container">
		<div style="height:120px;"></div>
		<div class="col-lg-6 col-lg-offset-3">
			<div class="row">
				<div class="col-sm-12">
					<c:if test="${not empty msg}">
						<c:out
							value="
							<div class='alert alert-info'>${msg}</div>
						"
							escapeXml="false" />
					</c:if>
				</div>
				<form action='<c:url value="/user/ModifyPassword" />' method="post">
					<div class="form-group">
						<label for="oldpswd">旧密码</label> <input class="form-control"
							type="password" name="oldpswd" required="required" />
					</div>
					<div class="form-group">
						<label for="newpswd">新密码</label> <input class="form-control"
							type="password" name="newpswd" id="p1" required="required" />
					</div>
					<div class="form-group">
						<label for="newpswd2">确认新密码</label> <input class="form-control"
							type="password" name="newpswd2" id="p2" required="required" />
					</div>
					<div class="form-group">
						<button id="btn-modify" class="btn btn-success col-xs-12 col-sm-12 col-md-5">更改密码</button>
					</div>
					<div class="form-group">
						<a class="btn btn-primary col-xs-12 col-sm-12 col-md-5  col-md-offset-2"
							onclick="javascript:document.location='<c:url value="/resume?method=myResume"/>';">返回首页</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src='<c:url value="/assets/bootstrap/js/jquery.js"/>'></script>
	<script src='<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>'></script>
	<script>
		$(document).ready(function() {
			$("#btn-modify").attr("disabled", "disabled");
			$("#p2").mouseout(function() {
				if ($("#p2").val() != $("#p1").val()) {
					$("#btn-modify").attr("disabled", "disabled");
				} else {
					$("#btn-modify").removeAttr("disabled");
				}
			});
		});
	</script>
</body>
</html>

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
<title>用户管理</title>
<link href='<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>用户管理</h1>
		</div>
		<div class="row">
			<div class="form-group col-sm-12 col-md-5 col-lg5 ">
				<input type="text" class="form-control" id="email" name="email"
					placeholder="邮箱" />
			</div>
			<div class="form-group col-sm-12 col-md-5 col-lg5 ">
				<input type="text" class="form-control" id="username"
					name="username" placeholder="用户名" />
			</div>
			<div class="form-group col-xs-12 col-sm-12 col-md-2 col-lg-2 ">
				<button class="btn btn-primary col-xs-12" id="search">
					<span class="glyphicon glyphicon-search"></span>搜索
				</button>
			</div>
		</div>

		<div class="row">
			<table class="table table-hover  table-condensed">

				<thead>
					<tr>
						<th>邮箱</th>
						<th>用户名</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="tbody-content">
				<!-- 
					<tr>
						<td>chioy@foxmail.com</td>
						<td>chioy</td>
						<td><a class="btn btn-xs btn-primary">查看</a> <a
							class="btn btn-xs btn-danger">删除</a></td>
					</tr>
					<tr>
						<td>741297479@qq.com</td>
						<td>Bangalore</td>
						<td><a class="btn btn-xs btn-primary">查看</a> <a
							class="btn btn-xs btn-danger">删除</a></td>
					</tr>
					<tr>
						<td>a@b.com</td>
						<td>Pune</td>
						<td><a class="btn btn-xs btn-primary">查看</a> <a
							class="btn btn-xs btn-danger">删除</a></td>
					</tr>
					 -->
				</tbody>
			</table>
		</div>

		<div class="row">
			<ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
		</div>



	</div>
	<script src='<c:url value="/assets/bootstrap/js/jquery.js"/>'></script>
	<script src='<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>'></script>
	<script>
		$(document).ready(function() {
			$("#search").click(function() {
				var tbody = $.ajax({
					async : false,
					cache : false,
					type : 'post',
					url : '<c:url value="/admin?method=query"/>',
					data : {
						'username' : $("#username").val(),
						'email' : $("#email").val(),
					}
				}).responseText;
				$("#tbody-content").html(tbody);
			});
		});
	</script>
</body>
</html>


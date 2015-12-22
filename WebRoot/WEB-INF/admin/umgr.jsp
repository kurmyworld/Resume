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
<title>管理面板</title>
<link href='<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href='<c:url value="/assets/bootstrap/plugins/artDialog/css/ui-dialog.css"/>'>
</head>
<body>
	<div class="container">
		<div class="rwo ">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#">用户管理</a></li>
				<li><a href='<c:url value="/admin?method=qmgr"/> '>问题管理</a></li>
			</ul>
		</div>
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
	<!-- 
	<script src='<c:url value="/assets/bootstrap/plugins/artDialog/lib/jquery-1.10.2.js" /> '></script>
	 -->
	<script
		src='<c:url value="/assets/bootstrap/plugins/artDialog/dist/dialog-min.js" />'></script>

	<script>
		$(document).ready(function() {
			search();
			$("#search").click(function() {
				search();
			});
		});
	</script>
	<script>
		function deleteUser(uid) {
			var msg = $.ajax({
				async : false,
				cache : false,
				type : 'post',
				url : '<c:url value="/admin?method=delUser"/>',
				data : {
					id : uid,
				}
			}).responseText;
			return msg;
		}
		function del(uid, id) {
			var d = dialog({
				title : '提示',
				content : '你确定删除此用户吗？他的简历信息也将被删除无法还原！',
				okValue : '确定',
				ok : function() {
					//tip(deleteUser(uid));
					var element = document.getElementById(id);
					tip(deleteUser(uid));
					remove(element);
					return true;
				},
				cancelValue : '取消',
				cancel : function() {
					tip("您取消了操作。");
				}
			});
			d.show();
		}
		function tip(msg) {
			var d = dialog({
				content : msg
			});
			d.show();
			setTimeout(function() {
				d.close().remove();
			}, 2000);
		}
		function search() {
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
		}
		function remove(element) {
			element.remove();
		}
	</script>
</body>
</html>


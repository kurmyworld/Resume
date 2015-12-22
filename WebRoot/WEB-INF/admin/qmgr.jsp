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
				<li><a href='<c:url value="/admin?method=umgr"/>'>用户管理</a></li>
				<li class="active"><a href="#">问题管理</a></li>
			</ul>
		</div>
		<div class="row">
			<h1>添加问题</h1>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
					<input id="question" name="question" type="text" placeholder="添加问题"
						class="form-control" />
				</div>
				<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
					<a id="add" class="btn btn-primary">添加问题</a>
				</div>
			</div>
		</div>

		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>问题</th>
					</tr>
				</thead>
				<tbody id="#tbody-content">
					<c:forEach var="q" items="${requestScope.qs}">
						<tr>
							<td><c:out value="${q.qid }" /></td>
							<td><c:out value="${q.question }" /></td>
						</tr>
					</c:forEach>
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
			$("#add").click(function() {
				var q=$("#question").val();
				var info = $.ajax({
					async : false,
					cache : false,
					type  : 'post',
					url   :  '<c:url value="/question?method=add"/>',
					data  : {"question":q}
				}).responseText;
				if(info!=0){
					$("#question").val("");
					$("tbody").append(info);
					tip("恭喜！！！添加成功！！！");
				}else{
					tip("抱歉！！！已经有该问题啦！！");
				}
			});
		});
	</script>
	<script>
		function tip(msg) {
			var d = dialog({
				content : msg
			});
			d.show();
			setTimeout(function() {
				d.close().remove();
			}, 2000);
		}
	</script>
</body>
</html>


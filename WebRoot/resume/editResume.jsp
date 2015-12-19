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
<title>Edit MyResume</title>
<link href='<c:url value="/assets/bootstrap/css/bootstrap.min.css" /> '
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<c:if test="${not empty requestScope.msg}">
			<div class="alert alert-success">
				<h1>${msg }<a href='<c:url value="/resume?method=myResume" />'>返回我的简历表</a></h1>
			</div>
		</c:if>
		<form action="<c:url value="/resume?method=editResume"/>" method="post">
			<div class="form-group">
				<label for=" pic"> 头像url： </label> <input type="url" name="pic"
					value='<c:out value="${resume.pic }"/>' class="form-control" />
			</div>
			<div class="form-group">
				<label for="name "> 姓名： </label> <input type="text"
					class="form-control" name="name"
					value="<c:out value="${resume.name }"/>" />
			</div>
			<div class="form-group">
				<label for="age "> 年龄： </label> <input type="number" name="age"
					min="0" max="99" value="<c:out value="${resume.age }"/>"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="sex "> 性别： </label> <select name="sex"
					class="form-control">

					<c:choose>
						<c:when test="${resume.sex==1 }">
							<option value="0">女</option>
							<option value="1" selected="selected">男</option>
						</c:when>
						<c:otherwise>
							<option value="0" selected="selected">女</option>
							<option value="1">男</option>
						</c:otherwise>
					</c:choose>
				</select>
			</div>
			<div class="form-group">
				<label for="profession "> 专业： </label> <input type="text"
					name="profession" value="<c:out value="${resume.profession } "/>"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="addr "> 地址： </label> <input type="text" name="addr"
					value="<c:out value="${resume.addr } "/>" class="form-control" />
			</div>
			<div class="form-group">
				<label for="tel "> 电话： </label> <input type="tel" name="tel"
					value="<c:out value="${resume.tel } "/>" class="form-control" />
			</div>
			<div class="form-group">
				<label for=" profile"> 个人简介： </label>
				<textarea name="profile" class="form-control"><c:out
						value="${resume.profile }" /></textarea>
			</div>
			<div class="form-group">
				<label for="ed_exp "> 教育经历： </label>
				<textarea name="ed_exp" class="form-control"><c:out
						value="${resume.ed_exp }  " /></textarea>
			</div>
			<div class="form-group">
				<label for="wk_exp"> 工作经历： </label>
				<textarea name="wk_exp" class="form-control"><c:out
						value="${resume.wk_exp }  " /></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">提交修改</button>
				<a class="btn btn-primary" href='<c:url value="/resume?method=myResume"/>'>返回简历</a>
			</div>

		</form>
	</div>
	<script src='<c:url value="/assets/bootstrap/js/jquery.js" />'></script>
	<script src='<c:url value="/assets/bootstrap/js/bootstrap.min.js" />'></script>
</body>
</html>

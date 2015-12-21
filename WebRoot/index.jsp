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
<link href="<c:url value="/assets/css/style.css"/>" rel='stylesheet'
	type='text/css' />
<link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1">


</head>
<body>
	<div class="main">
		<div class="header">
			<h1>登陆或者创建一个账户</h1>
		</div>
		<p>管理你的个人简历（其实就是个实训作业）</p>
		<form action="<c:url value="/User?method=regist"/>" method="post"
			onsubmit="return checkReg();">
			<ul class="left-form">
				<h2>创建一个账户:</h2>
				<li><input type="text" name="username" placeholder="用户名（个性域名）"
					required="required" autocomplete="off" /> <a id="info-username"
					class="icon ticker"> </a>
					<div class="clear"></div></li>
				<li><input type="email" name="email" placeholder="电子邮箱"
					autocomplete="off" required /> <a id="info-email"
					class="icon ticker"> </a>
					<div class="clear"></div></li>

				<li><select id="questions" name="qid" class="form-control"></select>
					<div class="clear"></div></li>

				<li><input type="text" placeholder="选择问题并填写答案" name="answer"
					autocomplete="off" required /> <a class="icon ticker"> </a>
					<div class="clear"></div></li>

				<li><input type="password" id="p1" placeholder="密码"
					name="userpswd" required /> <a id="pwd" class="icon ticker"> </a>
					<div class="clear"></div></li>

				<li><input type="password" id="p2" placeholder="确认密码" required />
					<a id="info-pswd" class="icon ticker"> </a>
					<div class="clear"></div></li>

				<li><input type="text" id="vCode" name="vCode"
					placeholder="验证码（点击小勾换一张）" autocomplete="off" required /> <a
					class="icon ticker" id="changeVcode"></a>
					<div class="clear"></div></li>

				<li><img id="vcode" style="width:440.468px;height:50px;"
					src='<c:url value="/vcode"/>' />
					<div class="clear"></div></li>

				<button id="btn-create" type="submit" class="btn btn-default">创建账户</button>
				<div class="clear"></div>

			</ul>
		</form>
		<form action="<c:url value="/User?method=login" />" method="post">
			<ul class="right-form">
				<h3>登陆我的账户:</h3>
				<div>
					<li><input type="text" name="email" placeholder="用户名或邮箱"
						required value='<c:out value="${user.email }"/>' /></li>
					<li><input type="password" name="userpswd" placeholder="密码"
						required /></li>
					<h4>
						<a href='<c:url value="/user?method=forgotten_step1"/>'>忘记密码点这里</a>
						<a href='<c:url value="/admin?method=login"/>'>管理员登陆点这里</a>
					</h4>

					<input type="submit" value="登陆">
				</div>
				<div class="clear"></div>
				<div>
					<c:if test="${not empty msg}">
						<div class="alert alert-warning">${msg }</div>
					</c:if>
				</div>
			</ul>
			<div class="clear"></div>

		</form>

	</div>
	<!-----start-copyright---->
	<div class="copy-right">
		<!--
						<p>Template 2014. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="Resume">个人简历</a> - Collect from <a href="http://www.chioy.cn/" title="chioy" target="_blank">chioy</a></p> 
   					-->
		<p></p>
	</div>
	<!-----//end-copyright---->
	<script src="<c:url value="/assets/bootstrap/js/jquery.js"/>"></script>
	<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>

	<script>
		$(document).ready(
				function() {
					var questionlist = $.ajax({
						async : false,
						cache : false,
						type : 'post',
						url : '<c:url value="/question?method=getList"/>'
					}).responseText;
					$("#questions").html(questionlist);
					$("a#pwd").mousedown(function() {
						$("input#p1").attr("type","text");
					});
					$("a#pwd").mouseup(function() {
						$("input#p1").attr("type","password");
					});
					$("#changeVcode").mousedown(
							function() {
								$("#vcode").attr(
										"src",
										'<c:url value="/vcode?x="/>'
												+ new Date().getTime());
							});
					$("#p2").change(function() {
						if ($("#p2").val() != $("#p1").val()) {
							$("#info-pswd").removeClass("ticker");
							$("#info-pswd").addClass("into");
							$("#btn-create").attr("disabled", "disabled");
						} else {
							$("#info-pswd").removeClass("into");
							$("#info-pswd").addClass("ticker");
							$("#btn-create").removeAttr("disabled");
						}
					});
				});
	</script>
</body>
</html>

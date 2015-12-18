<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Welcome MyResume</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="<c:url value="/assets/css/style.css"/>" rel='stylesheet' type='text/css' />
<script src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>" rel='stylesheet' type="text/css"/>
</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});
});
</script>
 <!--SIGN UP-->
<div class="login-form">

	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
			
	<div class="avtar">
		<img src="<c:url value="/assets/images/avtar.png" />" />
	</div>
			<form action="<c:url value="/Login"/>" method="post">
					<input type="text" required="required" autocomplete="off" class="text" placeholder="用邮箱登陆"  name="email" />
						<div class="key">
					<input type="password" required="required" name="userpswd" placeholder="请输入密码" />
						</div>
						<c:if test="${not empty requestScope.msg }"><div class="alert alert-info">${requestScope.msg }</div></c:if>
			<div class="signin">
				<input type="submit" value="登陆" />
			</div>
		</form>
</div>


<script src="<c:url value="/assets/bootstrap/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>

</body>
</html>

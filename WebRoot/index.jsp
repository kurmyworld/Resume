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
<link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
	function checkReg(){
		var p1 = document.getElementById("p1");
		var p2 = document.getElementById("p2");
		if(p1.value != p2.value){
			alert("两次输入的密码不同，请检查！");
			return false;
		}
		return true;
	}	
</script>

</head>
<body>
	<div class="main">
		<div class="header">
			<h1>登陆或者创建一个账户</h1>
		</div>
		<p>管理你的个人简历（其实就是个实训作业）</p>
		<form action="<c:url value="/User?method=regist"/>" method="post" onsubmit="return checkReg();">
			<ul class="left-form">
				<h2>创建一个账户:</h2>
				<li><input type="text" name="username" placeholder="用户名（个性域名）"
					required /> <a href="#" class="icon ticker"> </a>
					<div class="clear"></div></li>
				<li><input type="email" name="email" placeholder="电子邮箱" required />
					<a href="#" class="icon ticker"> </a>
					<div class="clear"></div></li>

				<li><select id="questions" name="qid" class="form-control"></select>
					<div class="clear"></div></li>

				<li><input type="text" placeholder="选择问题并填写答案" name="answer" required />
					<a href="#" class="icon ticker"> </a>
					<div class="clear"></div></li>

				<li><input type="password" id="p1" placeholder="密码" name="userpswd"
					required /> <a href="#" class="icon ticker"> </a>
					<div class="clear"></div></li>
				<li><input type="password" id="p2" placeholder="确认密码" required /> <a
					href="#" class="icon ticker"> </a>
				<div class="clear"></div></li>
				<li><input type="text" id="vCode" name="vCode" placeholder="点击绿色小勾更换验证码" required /> 
				<a href="" class="icon ticker" onclick="changeVcode()">
					 </a><a name="vcode"></a>
				<div class="clear"></div></li>
				
				<li><img style="width:440.468px;height:50px;" src='<c:url value="/vcode"/>'/>
				<div class="clear"></div></li>
				
				
				<input type="submit" value="创建账户" / >
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
						required value='<c:out value="${user.userpswd }"/>'/></li>
					<h4><a href='<c:url value="/user?method=forgotten_step1"/>'>------忘记密码点这里------</a></h4>
					<input type="submit" value="登陆">
				</div>
				<div class="clear"></div>
				<div><c:if test="${not empty msg}"><div class="alert alert-warning">${msg }</div></c:if></div>
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
	 <script src="<c:url value="/assets/js/Questions.js"/>"></script>
	    <script>
   		var inner = document.getElementById("questions");
   		loadAllQuestions('post','<c:url value="/question/QuestionList"/>',document.getElementById("questions"));
    </script>
    <script type="text/javascript">
    	function changeVcode(){
    		document.getElementById("vcode").src="<c:url value="/vcode"/>?time="+new Date().getTime();
    	}
    </script>    
</body>
</html>

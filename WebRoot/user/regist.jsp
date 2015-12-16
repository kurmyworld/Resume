<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>注册</title>
    <script src="<c:url value="/assets/js/Questions.js"/>"></script>
    
  </head>
  <body>
    <h1>${requestScope.msg}</h1>
    
    <form class="" action="<c:url value="/Regist" />" method="post">
      邮　箱：<input type="text" required="required" id="email" name="email" placeholder="请输入邮箱" value="${session.user.email}"/>
      <br />
      用户名：<input type="text" required="required" id="username" name="username" placeholder="请输入用户名" value="${session.user.username}"/>
      <br />
      选择安全问题：
      <select id="questions" name="qid">
      </select>
      <br />
      答　案：<input type="text" required="required" id="answer" name="answer" placeholder="请输入问题答案" />
      <br />
      密　码：<input type="password" required="required" id="userpswd" name="userpswd" placeholder="请输入密码" value="${session.user.userpswd}"/>
      <br />
      <%--
     重复密码：<input type="password" required="required" id="userpswd2" name="userpswd2" placeholder="请重复密码" value="${session.user.userpswd}"/>
      <br />
      --%>
      验证码：<input type="text" required="required"  name="vCode" placeholder="请输入验证码" />
      <img id="vcode" alt="vcode" src='<c:url value="/vcode" />'/><a href="#"  onclick="changeVcode();">刷新验证码 </a>
      <br />
      <input type="submit" value="注册"/>
    </form>
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

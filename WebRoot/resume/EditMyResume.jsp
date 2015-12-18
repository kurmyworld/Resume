<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Edit MyResume</title>
  </head>
  <body>
  <form action="<c:url value="/resume/ResumeUpdate"/>" method="post">
  头像url：<input type="url" name="pic" value="<c:out value="${resume.pic }"/>"/>
  <br/>
   姓名：<input type="text" name="name" value="<c:out value="${resume.name }" />" />
   <br/>
   年龄：<input type="number" name="age" min="0" max="99"  value="<c:out value="${resume.age }"/>"/>
   <br/>
   性别：<select name="sex">
   		<c:choose>
   			<c:when test="${resume.sex==1 }">
   				<option value="0">女</option>
   				<option value="1" selected="selected">男</option>
   			</c:when>
   			<c:otherwise>
   				<option value="0" selected="selected">女</option>
   				<option value="1" >男</option>
   			</c:otherwise>
   		</c:choose>
   </select>
   <br/>
   专业：<input type="text" name="profession"  value="<c:out value="${resume.profession } "/>"/>
   <br/>
   地址：<input type="text" name="addr"  value="<c:out value="${resume.addr } "/>"/>
   <br/>
   电话：<input type="tel" name="tel"  value="<c:out value="${resume.tel } "/>"/>
   <br/>
   个人简介：<textarea name="profile"><c:out value="${resume.profile }  "/></textarea>
   <br/>
   教育经历：<textarea name="ed_exp"><c:out value="${resume.ed_exp }  "/></textarea>
 <br/>
   工作经历：<textarea name="wk_exp"><c:out value="${resume.wk_exp }  "/></textarea>
   <br/>
   <h1>${msg }</h1>
   <input type="submit" value="提交修改！"/>
   </form>
  </body>
</html>

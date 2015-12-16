<%@ page language="java" import="java.util.*,com.chioy.domain.Question" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<Question> qs = (List)request.getAttribute("qs");
	pageContext.setAttribute("qs", qs);
%>
	<c:forEach var="q" items="${pageScope.qs}">
		<c:out value="<option value='${q.qid }'>${q.question}</option>" escapeXml="false"/>
	</c:forEach>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="utf-8">
	<title>MyResume</title>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">

	<!-- stylesheet css -->
	<link rel="stylesheet" href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />">
	<link rel="stylesheet" href="<c:url value="/resume/css/font-awesome.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resume/css/templatemo-blue.css"/>">
</head>
<body data-spy="scroll" data-target=".navbar-collapse">

<!-- preloader section -->
<div class="preloader">
	<div class="sk-spinner sk-spinner-wordpress">
       <span class="sk-inner-circle"></span>
     </div>
</div>

<!-- header section -->
<header>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<img src='
					<c:choose>
						<c:when test="${empty resume.pic}"><c:url value='/resume/images/tm-easy-profile.jpg'/></c:when>
						<c:when test="${resume.pic != ' ' }"><c:out value='${resume.pic }'/></c:when>
					</c:choose>
				'
				 class="img-responsive img-circle tm-border"
				style="width:255px;height:255px;"
				 alt="templatemo easy profile">
				<hr>
				<c:if test="${ not empty msg }"><h2 class="tm-title bold shadow">${msg}<jsp:forward page="/"/></h2></c:if>
				<h1 class="tm-title bold shadow"> 你好, 我是 <c:out value="${resume.name }"/></h1>
			</div>
		</div>
	</div>
</header>

<!-- about and skills section -->
<section class="container">
	<div class="row">
		<div class="col-md-6 col-sm-12">
			<div class="about">
				<h3 class="accent">个人简介</h3>
				<h2>My Resume Profile</h2>
				<p><c:out value="${resume.profile}"/></p>
			</div>
		</div>
		<div class="col-md-6 col-sm-12">
			<div class="skills">
				<h2 class="white">个人信息</h2>
				<strong>姓名:</strong>
				<span class="pull-right"><c:out value="${resume.name }"/></span>
				<!-- 
				 -->
					<div class="progress">
					<!-- 
						<div class="progress-bar progress-bar-primary" role="progressbar"
                        aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;"></div>
					 -->
					</div>
				
				<strong>性别：</strong>
				<span class="pull-right">
					<c:choose>
						<c:when test="${resume.sex ==1 }">男</c:when>
						<c:when test="${resume.sex ==0 }">女</c:when>
					</c:choose>
				</span>
					<div class="progress">
					<!-- 
						<div class="progress-bar progress-bar-primary" role="progressbar"
                        aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%;"></div>
					 -->
					</div>
				<strong>专业：</strong>
				<span class="pull-right"><c:out value="${resume.profession }"/></span>
					<div class="progress">
					<!-- 
						<div class="progress-bar progress-bar-primary" role="progressbar"
                        aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width: 95%;"></div>
					 -->
					</div>
			</div>
		</div>
	</div>
</section>

<!-- education and languages -->
<section class="container">
	<div class="row">
		<div class="col-md-8 col-sm-12">
			<div class="education">
				<h2 class="white">教育经历</h2>
					<div class="education-content">
							<div class="education-school">
					<!-- 
								<h5>School of Media</h5><span></span>
								<h5>2030 January - 2034 December</h5>
					
						<h4 class="education-title accent">New Web Design</h4>
					 -->
							</div>
						<p class="education-description">
						<c:out value="${resume.ed_exp}"/>
						</p>
					</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<div class="contact">
				<h2>联系方式</h2>
					<p><i class="fa fa-map-marker"></i><c:out value="${resume.addr }"/></p>
					<p><i class="fa fa-phone"></i> <c:out value="${resume.tel }"/></p>
					<p><i class="fa fa-envelope"></i> <c:out value="${user.email}"/></p>
			</div>
		</div>
	</div>
</section>

<!-- contact and experience -->
<section class="container">
	<div class="row">
		<!-- 
		
		<div class="col-md-4 col-sm-12">
			<div class="languages">
				<h2>Contact</h2>
					<p><i class="fa fa-map-marker"></i><c:out value="${resume.addr }"/></p>
					<p><i class="fa fa-phone"></i> <c:out value="${resume.tel }"/></p>
					<p><i class="fa fa-envelope"></i> <c:out value="${user.email}"/></p>
			</div>
		</div>
		 -->
		<div class="col-md-12 col-sm-12">
			<div class="experience">
				<h2 class="white">工作经验</h2>
					<div class="experience-content">
					<!-- 
					
						<h4 class="experience-title accent">Website Development</h4>
						<h5>New Media Company</h5><span></span>
						<h5>2035 January - 2036 April</h5>
					
					 -->
						<p class="education-description">
						<c:out value="${resume.wk_exp}"/>
						</p>
					</div>
			</div>
		</div>
	</div>
</section>

<!-- footer section -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<p><a  href="<c:url value="/index.jsp" /> ">我也要注册一个</a></p>
				<ul class="social-icons">
					<li><a href="#" class="fa fa-facebook"></a></li>
                    <li><a href="#" class="fa fa-google-plus"></a></li>
					<li><a href="#" class="fa fa-twitter"></a></li>
					<li><a href="#" class="fa fa-dribbble"></a></li>
					<li><a href="#" class="fa fa-github"></a></li>
					<li><a href="#" class="fa fa-behance"></a></li>
				</ul>
			</div>
		</div>
	</div>
</footer>

<!-- javascript js -->
<script src="<c:url value="/assets/bootstrap/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resume/js/jquery.backstretch.min.js"/>"></script>
<script src="<c:url value="/resume/js/custom.js"/>"></script>

</body>
</html>


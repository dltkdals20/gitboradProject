<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<title>여행정보사이트</title>
<style type="text/css"></style>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/main/mains">여행정보사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/main/mains">여행정보</a>
				<li><a href="/BBS/bbsView">여행게시판</a>
				<li><a href="/my/mypage">마이페이지</a>
			</ul>



			<ul class="nav navbar-nav navbar-right">
				<li style="padding-top:15px" >
				<c:if test = "${msg == 'success'}">
					<h8>${sessionScope.userName }(${sessionScope.userId})님 환영합니다.</h8>
				</c:if>
				</li>
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${userId}<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/out/logout">로그아웃</a></li>
					</ul></li>
			</ul>

		</div>
	</nav>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>
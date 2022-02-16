<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<title>JSP 게시판 웹 사이트</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
			<a class="navbar-brand" href="/">여행정보사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/BBS/bbsView">여행게시판</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="/mapping/login">로그인</a></li>
						<li><a href="/paths/join">회원가입</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbtron" style="padding-top: 20px;">
				<form:form modelAttribute="loginInfo" method="post" action="/mapping/login">
					<h3 style="text-align: center;">로그인화면</h3>
					<div class="form-group">
						<form:input type="text" class="form-control" placeholder="아이디"
							id = "userId" name="userID" path="userId" maxlength="20"/>
					</div>
					<div class="form-group">
						<form:input type="password" class="form-control"
							id= "userPw" placeholder="비밀번호" name="userpassword" path="password" maxlength="20"/>
						
					</div>
					<input type="submit" id ="btnLogin" class="btn btn-primary form-control"
						value="로그인">
						<li><a href="/mapping/idlook">아이디 찾기</a></li>
						<li><a href="/mapping/password">비밀번호 찾기</a></li>
				<c:if test = "${msg == 'failure'}">
					<div style ="color: red">
						아이디 또는 비밀번호가 일치하지 않습니다.
					</div>
				</c:if>
				<c:if test = "${msg == 'logout'}">
					<div style ="color: red">
						로그아웃이 되었습니다.
					</div>
					</c:if>
				</form:form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	<script >
		$(document).ready(function(){
			$("#btnLogin").click(function(){
				var userId = $("#userId").val();
				var userPw = $("#userPw").val();
				
				if(userId == "" || userId == null){
					alert("아이디를 입력해주세요.");
					return false;
					
				}
				if(userPw == "" || userId == null){
					alert("비밀번호를 입력해주세요.");
					return false;
					// 페이지를 안넘어가게 하는 기능을 함.
					
			
				}
			});
		});
	</script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>
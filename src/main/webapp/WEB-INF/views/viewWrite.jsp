<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">

<title>여행정보사이트</title>
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
			<a class="navbar-brand" href="main.jsp">여행정보사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a>
				<li class="active"><a href="/BBS/bbsView">게시판</a></li>
			</ul>

		
				<ul class="nav navbar-nav navbar-right">
				<li style="padding-top: 15px"><h8>${sessionScope.userName }(${sessionScope.userId})님
					환영합니다.</h8></li>
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${userId}<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="/out/logout">로그아웃</a></li>

					</ul></li>
			</ul>
		
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/out/logout">로그아웃</a></li>
					</ul></li>
			</ul>
		
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<form method="post" action="/write/writeView">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
								글쓰기 양식</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td>닉네임 :   ${list.nicName}</td>
							
						</tr>
						<tr>
							<td>제목 :   ${list.title}</td>
						</tr>
						<tr>
							<td>여행지역 :   ${list.location}</td>
						</tr>
						
								
						<tr>	
							<td>여행날짜 :   ${list.date}</td>

						</tr>
						<tr>	
							<td>글쓴날짜 :   ${list.writeDate}</td>

						</tr>
						<tr>	
							<td>내용 :   ${list.text}</td>

						</tr>
						<tr>	
							<td>평점 :   ${list.star}</td>

						</tr>
					</tbody>

				</table>
				
				<c:if test = "${sessionScope.nickName == list.nicName}">
					<button class="btn btn-primary pull-left" type="button" onclick="location.href='/update/updating?bbsID=${list.id}'">수정</button>
					<button class="btn btn-primary pull-left" type="button" onclick="location.href='/update/delete?bbsID=${list.id}'">삭제</button>
				</c:if>
				
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>
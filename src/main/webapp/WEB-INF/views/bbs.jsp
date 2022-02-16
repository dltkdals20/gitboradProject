<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<style>
	.current {
		color: red;
	}
</style>
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
			<a class="navbar-brand" href="/main/mains">여행정보사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/main/mains">여행정보</a>
				
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
			
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
						<th style="background-color: #eeeeee; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:if test ="${empty list}">
						<p>값이 없습니다.</p>
					</c:if>
				
					<c:if test ="${not empty list}">
						<c:forEach var = "Info"  items ="${list}">
							<tr>
								<td>${Info.id}</td>
								<td><a href="/view/viewMapping?bbsID=${Info.id}&count=${Info.count}">${Info.title}</a></td>
								<td>${Info.nicName}</td>
								<td>${Info.writeDate}</td>
								<td>${Info.count}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
				
			</table>
				<c:if test ="${a == null || a == 0}">
					<c:if test="${totalpage <= 3}">
						<c:forEach var = "pageNum1" begin = "1" end = "${totalpage}" >
			 				<a href = "/BBS/coutView?page=${pageNum1}&number=${0}" >[${pageNum1}]</a>
			       		</c:forEach>
		       		</c:if>
		       		<c:if test="${totalpage > 3}">
						<c:forEach var = "pageNum1" begin = "1" end = "3" >
			 				<a  href = "/BBS/view?viewpage=${pageNum1}&number=${0}" >[${pageNum1}]</a>
			       		</c:forEach>
			       		<a href = "/BBS/coutView?page=3">다음</a>
		       		</c:if>
	       		</c:if>
	       		<c:if test ="${a != null && a != 0}"> 
	       			<c:if test="${totalpage <= a+2}">
	       				<c:if test ="${a != 1}"> 
				       		<a href ="/BBS/maius?maius=${a-3}" >이전</a>
			       		</c:if>
		       			<c:forEach var = "pageNum1" begin = "${a}" end = "${totalpage}" >
				 			<a class="pages" href = "/BBS/view?viewpage=${pageNum1}&number=${a}" >[${pageNum1}]</a>
				       	</c:forEach>
			       	</c:if>
	       			<c:if test="${totalpage > a+2}">
	       				<c:if test ="${a != 1}"> 
				       		<a href = "/BBS/maius?maius=${a-3}" >이전</a>
				       	</c:if>
		       			<c:forEach var = "pageNum1" begin = "${a}" end = "${a+2}" >
				 			<a class="pages" href ="/BBS/view?viewpage=${pageNum1}&number=${a}" >[${pageNum1}]</a>
				       	</c:forEach>
				       	<a href = "/BBS/coutView?page=${a+2}">다음</a>
			       	</c:if>
				</c:if>
				
				<a href="/write/writeView" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
<script>
let url = new URL(window.location);
let currentPage = new URLSearchParams(url.search).get("viewpage");
currentPage = "[" + currentPage + "]";
document.querySelectorAll(".pages").forEach(function (e) {
	console.log(e.textContent);
	if (e.textContent == currentPage) {
		e.classList.add("current");
	}
});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/resource/ckeditor/ckeditor.js"></script>
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
		
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<form:form modelAttribute="writeInfo"  method="post" action="/write/writeView">
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
							<td><form:input type="text" class="form-control"
								placeholder="제목" name="title" path="title" maxlength="50"/><form:errors path="title"/></td>
						</tr>
						<tr>
							<td><form:input type="text" class="form-control"
								placeholder="여행 지역" name="location" path="location"  maxlength="50"/><form:errors path="location"/></td>
						</tr>
						<tr>
							<td><form:input type="date" class="form-control"
								placeholder="여행 날짜" name="date" path="date" maxlength="50"/></td>
						</tr>
						
								
<!-- 						<tr>	 -->
<%-- 							<td><form:textarea class="form-control" --%>
<%-- 									placeholder="글 내용" name="text" path="text" maxlength="2048" --%>
<%-- 									style="height: 350px;"/></textarea><form:errors path="text"/></td> --%>

<!-- 						</tr> -->
						
							<tr>	
								<td><form:textarea id = "editor4" name= "editor4" path="text"/></textarea><form:errors path="text"/></td>
								
							</tr>

						<tr>
							<td><form:input type="number" step="0.1" class="form-control"
								placeholder="평점" name="bbsTitle" path="star"  maxlength="50"/></td>
						</tr>
											
					</tbody>

				</table>
				<input type="submit" class="btn btn-primary pull-right" value="완료">
			</form:form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
<script>
CKEDITOR.replace('editor4',{filebrowserUploadUrl:'/mine/imageUpload.do'});</script>
</html>
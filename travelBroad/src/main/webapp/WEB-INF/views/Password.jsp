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
<title>여행정보사이트</title>
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
				
			</ul>
			
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbtron" style="padding-top: 20px;">
				<form id= "password" method="post" action="/mapping/login">
					<h3 style="text-align: center;">비밀번호찾기</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							id = "userId" name="userID" maxlength="20"/>
					</div>
					<div class="form-group">
						   <input type="text" class="form-control" id= "phone" placeholder="핸드폰번호(-)하이픈을빼고 입력하세요" 
						   name="phoneNumber" maxlength="11"/>
					</div>
					<input type="button" id ="btnPassword" class="btn btn-primary form-control"
						value="비밀번호찾기">
					
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	<script>
		$(document).ready(function(){
			$("#btnPassword").click(function(){
				var username = $("#userId").val();
				var userPhone = $("#phone").val();
				
				if(username == "" || username == null){
					alert("아이디를 입력해주세요!.");
					return false;
					
				}
				if(userPhone == "" || userPhone == null){
					alert("핸드폰 번호를 입력해주세요.");
					return false;
					// 페이지를 안넘어가게 하는 기능을 함.
				}else{
					if(userPhone.length < 10){
					alert("핸드폰번호를 11자리까지 입력해주세요.");
					return false;
					}else{
						return false;
					}
				}
			});
		});
	

 	</script>
	
	
	 <script>
		  $("#btnPassword").click(function(){
			  var formData = $("#password").serialize();
				$.ajax({
					url: '/Id/PasCheck',
					type: 'POST',
					data: formData,
					success: function(data1) {
					console.log(data1);	
						if (data1 == "fail") {
							alert("일치하는 정보가 없습니다.");						
						} else if(data1 == "0") {
							
						}else{
							alert("회원님의 비밀번호는." + data1);
						}
					},
					
				});
			
		  });
</script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>
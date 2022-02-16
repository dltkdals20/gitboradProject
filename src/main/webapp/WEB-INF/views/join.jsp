<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<title>여행정보사이트</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
.id_div::after{    
	display: block;
    clear: both;
    content: '';
    }
.id_input{
	width: calc(100% - 93px);
    float: left;
	} 
.id_button{
	width: 84px;
    float: right;
}
</style>
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
	<script>
		function checkit(){
	
			let password = $("#pass").val();
 			let passwords = $("#passcheck").val();
			let name = $("#names").val();
			let phone = $("#phone").val();
			let nick = $("#nickId").val();
			let gender = $("#men").val();
			let gender1 = $("#woman").val();
			let a = $("#inlineCheckbox1").val();
			let b = $("#inlineCheckbox2").val();
			let c = $("#inlineCheckbox3").val();
			let d = $("#inlineCheckbox4").val();
			let e = $("#inlineCheckbox5").val();
			let f = $("#inlineCheckbox6").val();
			let g = $("#inlineCheckbox7").val();
			let h = $("#inlineCheckbox8").val();
			let r = $("#inlineCheckbox9").val();
			let n = $("#inlineCheckbox10").val();
	
			
			
	
			
			if( password == null || password == ""){
				alert("비밀번호를 입력해주세요.")
				console.log("확인 해주시요 " + password);
					
			return false;
			}else if(passwords == null || passwords == ""){
				alert("확인비밀번호를 입력해주세요.")
					
			return false;
			}else if(name == null || name == ""){
				alert("이름을 입력해주세요.")
				
			return false;
			}else if(phone == null || phone == ""){
				alert("핸드폰 번호를 입력해주세요.")
				
			return false;
			}else if(nick == null || nick == ""){
				alert("닉네임을 입력해주세요.")
				
			return false;
			}else if(gender == null || gender == "" || gender1 == null || gender1 == ""){
				alert("성별을 입력해주세요.")
					
			return false;
			}
			
			else if(a == null ||b == null ||c == null ||d == null ||e == null ||f == null ||g == null ||h == null ||r == null ||n == null){
				alert("하나라도 체크해주세요.")
					
			return false;
		
			}else if (password != passwords){
				alert ("비밀번호가 일치하지 않습니다.")
			return false;
			}
			
		}
	
	</script>
	
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbtron" style="padding-top: 20px;">
				<form:form modelAttribute="joinInfo" method="post" action="/paths/join" onsubmit ="return checkit()">
					<h3 style="text-align: center;">회원가입화면</h3>

					<div class="form-group id_div">
						<div class="col-auto id_input">
							<form:input type="text" class="form-control" placeholder="아이디"
								id="user" name="userID" path="userId" maxlength="20" />
							<form:errors path="userId" />
						</div>

						<div class="col-auto id_button">
							<button class="btn btn-secondary" id="duplicate_check"
								type="button" >중복체크</button>
							
						</div>
					</div>

					<div class="form-group">
						<form:input type="password" class="form-control"
							id= "pass" placeholder="비밀번호" name="userPassword" path="password"
							maxlength="20" />
						<form:errors path="password" />
					</div>
					<div class="form-group">
						<form:input type="password" class="form-control"
							placeholder="비밀번호 확인" name="userPasswordCheck"
							id = "passcheck" path="passwordCheck" maxlength="20" />
						<form:errors path="passwordCheck" />
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control" placeholder="이름"
							id = "names" name="userName" path="name" maxlength="20" />
						<form:errors path="name" />
					</div>
					<div class="form-group">
						<form:input type="text" id="phone" class="form-control"
							placeholder="핸드폰 번호" name="phones" path="phone" maxlength="20" />
						<form:errors path="phone" />
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control" placeholder="닉네임"
							id="nickId" name="UsernickName" path="nickName" maxlength="20" />
						<form:errors path="nickName" />
					</div>
					<div>
						<div class="col-auto">
							<button class="btn btn-secondary" id="nickName_check"
								type="button" >닉네임 중복체크</button>
							
						</div>
					</div>
										
					<div class="form-group" style="text-align: center">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <form:radiobutton
									id = "men" path="gender" label="남자" value="남자" />
							</label> <label class="btn btn-primary"> <form:radiobutton
									id = "woman" path="gender" label="여자" value="여자" /> 
							</label>
							<form:errors path="gender" />
						</div>
					</div>

					<div>최근여행지는?</div>
					<div class="form-group">
						<form:checkbox class="form-group-input" path="checkBox"
									id="inlineCheckbox1" value="서울" />
						<label class="form-group-input" for="inlineCheckbox1">서울</label>

						<form:checkbox class="form-group-input" path="checkBox"
								 id="inlineCheckbox2" value="부산" />
						<label class="form-group-input" for="inlineCheckbox1">부산</label>


						<form:checkbox class="form-group-input" path="checkBox"
								 id="inlineCheckbox3" value="대구" />
						<label class="form-group-input" for="inlineCheckbox1">대구</label>


						<form:checkbox class="form-group-input" path="checkBox"
							 	id="inlineCheckbox4" value="경주" />
						<label class="form-group-input" for="inlineCheckbox1">경주</label>


						<form:checkbox class="form-group-input" path="checkBox"
								id="inlineCheckbox5" value="울산" />
						<label class="form-group-input" for="inlineCheckbox1">울산</label>


						<form:checkbox class="form-group-input" path="checkBox"
								id="inlineCheckbox6" value="전라남도" />
						<label class="form-group-input" for="inlineCheckbox1">전라남도</label>

						<form:checkbox class="form-group-input" path="checkBox"
								id="inlineCheckbox7" value="하동" />
						<label class="form-group-input" for="inlineCheckbox1">하동</label>

						<form:checkbox class="form-group-input" path="checkBox"
								id="inlineCheckbox8" value="제주도" />
						<label class="form-group-input" for="inlineCheckbox1">제주도</label>

						<form:checkbox class="form-group-input" path="checkBox"
								 id="inlineCheckbox9" value="창원" />
						<label class="form-group-input" for="inlineCheckbox1">창원</label>

						<form:checkbox class="form-group-input" path="checkBox"
								id="inlineCheckbox10" value="지리산" />
						<label class="form-group-input" for="inlineCheckbox1">지리산</label>

						<form:errors path="checkBox" />

					</div>

					<div class="form-group">
						<form:input type="text" class="form-control" placeholder="기타여행지"
							 name="travel" path="otherTravel" maxlength="20" />
						<form:errors path="otherTravel" />
					</div>


					<input type="submit" id="btn" class="btn btn-primary form-control"
						value="회원가입" disabled >
				</form:form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	
	<script>
		
 				//아이디가 없고 버튼을 눌렷을때
					$(document).ready(function(){
						var idS = 1;
						var nickS = 1;
					$("#duplicate_check").click(function(){
						var id = $("#user").val();
						
						name , "id"
						if(id == ""){
							alert("아이디를 입력해주세요.");
				
				
						}else{
							//아이디 값이 있을때
							console.log(id);
							$.ajax({
								url : '/paths/ID_Check',
								type : 'POST',
								dataType : 'text',
								contentType : 'text/plain; charset=utf-8;',

								data : id,
								success : function(data) {
									console.log(data);
									if (data == 0) {
										idS = data;
										console.log("아이디가 없음");
										alert("사용하실 수 있는 아이디입니다.");
										if(idS == 0 && nickS == 0){
											$("#btn").attr('disabled', false);
												
											}
																		
									} else {
										idS = data;
										console.log("아이디가 있음");
										alert("중복된 아이디가 존재합니다.");
									}
								},
								error : function() {

								}
							});
						}
											
					
					});
					
					$("#nickName_check").click(function(){
						var nick = $("#nickId").val();
						if(nick == ""){
							alert("닉네임을 입력해주세요.");
						
						 
						}else{
							console.log(nick);
							$.ajax({
								url : 'Nick_Check',
								type : 'POST',
								dataType : 'text',
								contentType : 'text/plain; charset=utf-8;',

								data : nick,
								success : function(data) {
									console.log(data);
									if (data == 0) {
										nickS = data;
										console.log("닉네임 없음");
										alert("사용할 수 있는 닉네임입니다.");
										
										if(idS == 0 && nickS == 0){
										$("#btn").attr('disabled', false);
											
										}
									} else {
										nickS = data;
										console.log("닉네임 있음");
										alert("중복된 닉네임이 존재합니다.");
									}
								},
								error : function() {

								}
							});
							
						}
					});

										
					});
 				
 				
// 			}
		
// 		}
	</script>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>
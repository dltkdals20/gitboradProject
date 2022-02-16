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
            <form id= "idLook" method="post" action="/Id/IdLook" onsubmit ="return checkit()">
               <h3 style="text-align: center;">아이디찾기</h3>
               <div class="form-group">
                  <input type="text" class="form-control" placeholder="이름" id = "userName" name="name" maxlength="11"/>
               </div>
               <div class="form-group">
                  <input type="text" class="form-control"  id= "phone" placeholder="핸드폰번호(-)하이픈을빼고 입력하세요" name="phoneNumber" maxlength="11"/>
               </div>
               <button type="submit" id ="btn1" class="btn btn-primary form-control">아이디찾기</button>
            </form>
         </div>
      </div>
      <div class="col-lg-4"></div>
   </div>
   
   <script>
	function checkit(){
			var username = $("#userName").val();
			var userPhone = $("#phone").val();
			console.log("확인 해주시요 " + username);
			console.log("확인 해주시요 " + userPhone);
		
			
			if(username == "" || username == null){
				alert("이름을 입력해주세요!.");
				return false;
				//onsubmit의 경우에는 return false를 만나게 되면
				//사용자가 입력한 폼을 컨트롤러에게 전송하지 않고
				//그대로 멈춰 있게 한다.
			}
			
			if(userPhone == "" || userPhone == null){
				alert("핸드폰 번호를 입력해주세요.");
				return false;
				// 페이지를 안넘어가게 하는 기능을 함.
			}else{
				if(userPhone.length <= 10){
				alert("핸드폰번호를 11자리까지 입력해주세요.");
				return false;
				}else{
					return false
					//폼이 두번 전송되지 않게 하는 false 문입니다.
					//return false를 적어주지 않으면 폼이 계속 두번 전송되는 경우가 발생하게 되었습니다.
					//원래는 onsubmit은 return false를 만나게 되는 순간 멈추게 되어 잇는 형식으로 되어있습니다.
					//저의 경우에는 계속 폼이 2번 전송이 되어 else를 추가하여 return false를 추가하여 
					//폼이 한번만 전송되게 만들었습니다.
				}
			}
		}
	
	
 </script>
  
   <script>
  $("#btn1").click(function(){
	  var formData = $("#idLook").serialize();
		$.ajax({
			url: '/Id/IdLook',
			type: 'POST',
			data: formData,
			success: function(data1) {
				//IdLookController로 부터 넘어온 결과 값은 funtion(data1)에 담기게 됩니다.
				//그 결과 값을 아래의 if문으로 통해 조건식을 만들어 사용자에게 해당하는 alert 창을 보여주게 됩니다.
				if (data1 == "fail") {
					alert("아이디가 존재하지 않습니다.");	
				} else if(data1 == "0"){
					
				}else{
					alert("회원님의 아이디는" + data1)
				}		
					
			},
			
		});
	
  });
</script>

   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="/resource/js/bootstrap.min.js"></script>
   
</body>
</html>
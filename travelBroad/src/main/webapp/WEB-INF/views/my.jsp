<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
//캐시막기 내용임. 브라우져는 뒤로가기를 눌리면 캐시를 사용해서 바로 그 페이지를
//보여주는데 마이페이지에서 로그아웃을 한 뒤 다시 뒤로가기를 눌리면 브라우져에
//저장되어 있던 캐시가 다시 마이페이지를 보여주는 형태가 되어서 캐시 막기로 
//다시 로그인 페이지로 돌아가겠끔 함.
response.setHeader("pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.addHeader("Cache-Control", "No-store");
response.setDateHeader("Expires", 1L);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<!--<meta name="viewport" content="width=device-width,initial-scale=1"> -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="/resource/css/mypage.css">
<meta charset="UTF-8">
<style>
	.current {
		color: red;
	}
</style>
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
				<li><a href="/main/mains">여행게시판</a>
				<li><a href="/my/mypage">마이페이지</a>
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
			</ul>
		</div>

	</nav>
	<div class="my_content_box">
		<div class="my_intro">
			<form>
				<div class="my_imgdiv" >
					<img src="/mine/ckImgSubmits.do?nickName=${list.nickName}" class="my_img">
					<div class="my_imgfile">
						<form id="FILE_FORM" method="post" action="/file/file_Check" enctype="multipart/form-data">
							<input type="file" id="FILE_TAG" name="userfile"  class="btn btn-primary pull-left img_input">
							<input type="button" id ="btn" class="img_btn" value="변경">
						</form>
					</div>
				</div>
				<div class="my_cont">
					<div class="ul">
						<div class="li">
							<div class="tt">이름</div>
							<div class="tx">${list.name}</div>
						</div>
						<div class="li">
							<div class="tt">닉네임</div>
							<div id="nick" class="tx">${list.nickName}</div>
						</div>
						<div class="li">
							<div class="tt">아이디</div>
							<div class="tx">${list.userId}</div>
						</div>
						<div class="li">
							<div class="tt pn_tt">연락처</div>
							<input type="text" class="tx pn_input" size="10"
								maxlength="13"  id= "phoned" name= "phonesed" placeholder="-하이픈을 붙여주세요" value="${list.phone}"/>
							<input type="button" id= "btn2" class="btn btn-primary pull-right tx pn_btn" value="수정">	
						</div>
						<div class="li">
							<div class="tt">성별</div>
							<div class="tx">${list.gender}</div>
						</div>
					</div>
				</div>
				
			</form>
				
		</div>
		
		
		<div class="my_notice">
			<div class="tt">내가 올린 게시글</div>
			<div class="notice">
				<div class="tt">
					<div class="li no_li">No</div>
					<div class="li tt_li">제목</div>
				
				</div>
				
				<c:if test ="${empty borad}">
						<p>값이 없습니다.</p>
					</c:if>
				
					<c:if test ="${not empty borad}">
						<c:forEach var = "Info"  items ="${borad}">
						
				<div class="cont">
					<div class="cont_ul">
						<div class="li no_li">${Info.id}</div>
						<div class="li tt_li"><a href= "/my/myList?bbsID=${Info.id}">${Info.title}</a></div>
					</div>
					
				</div>
				</c:forEach>
					</c:if>
			
			</div>
			<div class="pagenation">
				<c:if test ="${a == null || a == 0}">
						<c:if test="${totalpage <= 3}">
							<c:forEach var = "pageNum1" begin = "1" end = "${totalpage}" >
				 				<a href = "/list/coutList?page=${pageNum1}&number=${0}&nick=${list.nickName}" >[${pageNum1}]</a>
				       		</c:forEach>
			       		</c:if>
			       		<c:if test="${totalpage > 3}">
							<c:forEach var = "pageNum1" begin = "1" end = "3" >
				 				<a  href = "/list/ListVeiw?viewpage=${pageNum1}&number=${0}&nick=${list.nickName}" >[${pageNum1}]</a>
				       		</c:forEach>
				       		<a href = "/list/coutList?page=3&nick=${list.nickName}">다음</a>
			       		</c:if>
		       		</c:if>
		       		<c:if test ="${a != null && a != 0}"> 
		       			<c:if test="${totalpage <= a+2}">
		       				<c:if test ="${a != 1}"> 
					       		<a href ="/list/maiuslist?maius=${a-3}&nick=${list.nickName}" >이전</a>
				       		</c:if>
			       			<c:forEach var = "pageNum1" begin = "${a}" end = "${totalpage}" >
					 			<a class="pages" href = "/list/viewMy?viewpage=${pageNum1}&number=${a}&nick=${list.nickName}" >[${pageNum1}]</a>
					       	</c:forEach>
				       	</c:if>
		       			<c:if test="${totalpage > a+2}">
		       				<c:if test ="${a != 1}"> 
					       		<a href = "/list/maiuslist?maius=${a-3}&nick=${list.nickName}" >이전</a>
					       	</c:if>
			       			<c:forEach var = "pageNum1" begin = "${a}" end = "${a+2}" >
					 			<a class="pages" href ="/list/viewMy?viewpage=${pageNum1}&number=${a}&nick=${list.nickName}" >[${pageNum1}]</a>
					       	</c:forEach>
					       	<a href = "/list/coutList?page=${a+2}&nick=${list.nickName}">다음</a>
				       	</c:if>
					</c:if>
				</div>	
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
 
  <script>
  $("#btn").click(function(){
		var form = $("#FILE_FORM")[0]
		var formData = new FormData(form);
		 formData.append("userfile", $("#FILE_TAG")[0].files[0]);
		console.log("andjtdlsrkdy" + formData);
		$.ajax({
			url : '/file/file_Check',
			type : 'POST',
			data: formData,
			processData: false,
			contentType: false,
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
					location.href="/my/mypage"; 
					alert("이미지가 변경되었습니다..");
				}
			},
			error : function() {

			}
		});
	
  });

</script>

 <script>
 $("#btn2").click(function(){
	 var phones = $("#phoned").val();
	 if(phones == "" || phones == null || phones.length <=12){
			alert("'-'하이픈 또는 핸드폰번호를 다시 확인해주세요. ");
		 
	 }else{
	 console.log("andjtdlsrkdy" + phones);
		$.ajax({
			url : '/myphones/phonenumber',
			type : 'POST',
			data : phones,
			
		success : function(data) {
				console.log(data);
				if (data == 1) {
				alert("핸드폰 번호가 수정되었습니다.");
				}else{
				alert("수정되지 않앗습니다.");	
				}
			},
			
		}); 
	 }
		
	});
						


 </script>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 구글폰트 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<!-- css 파일 링크 -->
<link rel="stylesheet" type="text/css" href="css/header_style.css">
<!-- 아이콘 가져오기 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

</head>
<body>

	<header>
		
		<a href="main.jsp" class="logo"><img src="img/logo.png" width="180"></a><!-- 로고 이미지 -->
		
		<nav class="navbar">
			<a href="main.jsp">HOME</a>
			<a href="#">MENU</a>
			<a href="#">STORE</a>
			<a href="#">NEWS</a>
			<a href="#">ORDER</a>
		</nav> 
		
		<div class="icons">
			<i class='fa fa-bars' id="menu-bar"></i> <!-- 창이 작아지면 메뉴바가 생김 -->
			<a href="login.jsp" id="login" class='fa fa-unlock'></a> <!-- 로그인 버튼 -->
			<a href="#" id="ask" class='fas fa-headphones-alt'></a> <!-- 고객센터(문의) 버튼 -->
			<!-- 관리자 페이지로 이동하는 아이콘도 나중에 만들어서 연결하기  -->
		</div>
		
	</header>
	
	<!-- 자바스크립트 file link -->
	<script src="js/main_script.js"></script>

</body>
</html>
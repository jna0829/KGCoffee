<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- 구글폰트 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<!-- css 파일 링크 -->
<link rel="stylesheet" type="text/css" href="../../css/login_style.css">
<link rel="stylesheet" type="text/css" href="../../css/header_style.css">

<script src="/kgCoffee/js/jquery-3.7.0.min.js"></script> <!-- jquery -->

</head>
<body>

	<%@include file="../../include/header.jsp" %>
	
	<!-- join section start ---------------------------------------------------------------- -->
	<div class="container">
		
		<div class="form-box">
			<form action="/kgCoffee/user/join.do" method="post" name="joinform">
				
				<h2>Join</h2>
				
				<div class="input-box">
					<input type="text" name="user_id" id="id" placeholder="아이디" required>
				</div>
				
				<div class="input-box">
					<input type="password" name="user_pw" id="pw" placeholder="비밀번호" required>
				</div>
				
				<div class="input-box">
					<input type="text" name="user_name" id="name" placeholder="이름" required>
				</div>
				
				<div class="input-box">
					<p class="font">생년월일<br></p>
					<input type="date" name="birthday" placeholder="생년월일" required>
				</div>
				
				<div class="input-box">
					<input type="text" name="tel" id="tel" placeholder="전화번호" required>
				</div>
				
				<div class="button">
					<input type="submit" class="btn" value="회원가입" onClick="return check();">
				</div>
			
			</form>
		</div>
	
	</div> <!-- join section end -->
    
	<script src="/kgCoffee/js/user_script.js"></script>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지</title>

<link rel="stylesheet" href="./css/adminMain.css?after">
<link rel="stylesheet" href="./css/adminNav.css?after">
<link rel="stylesheet" href="/kgCoffee/css/adminOrderData.css?after">


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- chart js CDN -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>
<body>

	<div class="wrap">

		<!-- nav-start ------------------------------------------------------- -->
		<%@ include file="adminSide.jsp" %>
		<!-- nav-end -------------------------------------------------------- -->


		<section class="content_section">

			<div class="content_hedear_wrap">
				<div class="content_header">
					<div class="header_title">주문 데이터 분석 페이지</div>
				</div>
			</div>

			<div class="content_wrap">
				<div class="content">


					</div>

				</div>
			</div>
		</section>
	</div>
	
	
	<script>
	
	//아코디언 메뉴 클릭 이벤트
	function arccodionMenu(){
		
		console.log($(".select-chart"));
	    $(".select-chart").toggleClass("show");
	    
	    
	}
	
	$(".nav_menu li").click(function(){
		event.stopPropagation();
		
		$(".active").removeClass("active");
		
		$(this).toggleClass("active");
		
		
		
	});
	
		</script>






</body>
</html>
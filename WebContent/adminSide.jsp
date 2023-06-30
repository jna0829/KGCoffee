<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		<!-- nav-start ------------------------------------------------------- -->
		<section class="nav_section">
			<div class="nav_wrap">
				<div class="nav">

					<ul class="nav_menu">

						<a href="/kgCoffee/view/user/index.jsp"> 
							<img src="/kgCoffee/img/logo-removebg.png" width="200">
						</a>

						<a class="nav_page">관리자 페이지</a>

						<li><a href="#" class="nav_list">메뉴관리</a></li>
						<li><a href="#" class="nav_list">회원관리</a></li>
						<li><a href="#" class="nav_list" onclick="arccodionMenu()">주문데이터분석</a>
								<ul class="select-chart">
									<li class="chart-age"><a class="nav_list_s">연령별 분석</a></li>
									<li class="chart-menu"><a class="nav_list_s">메뉴별 분석</a></li>
									<li class="chart-store"><a class="nav_list_s">매장 분석</a></li>
								</ul>
						</li>
					</ul>
					

				</div>
			</div>
		</section>
		<!-- nav-end -------------------------------------------------------- -->


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




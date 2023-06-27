<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>

<link rel="stylesheet" href="/kgCoffee/css/header_style.css"
	type="text/css">
<link rel="stylesheet" href="/kgCoffee/css/userOrderList.css?after"
	type="text/css">
<link rel="stylesheet" href="/kgCoffee/css/userOrderView.css?after" type="text/css">

</head>
<body>

	<%@include file="../../include/header.jsp"%>

	<section class="mypage" id="mypage">

		<div class="payment">

			<ul class="paymentList">
				<li class="select_btn_list">
					<div class="select_btn">
						<button type="button" class="btn_select_list"
							onclick="location.href='#'">주문 상세 리스트</button>
					</div>
					<div class="select_btn">
						<button type="button" class="btn_select_list"
							onclick="location.href='/kgCoffee/view/mypage/userModifyCk.jsp'">개인정보
							확인/수정</button>
					</div>
				</li>
			</ul>


			<ul class="paymentList">

				<!-- --------------------------------------------------- -->
				<c:forEach var="dto" items="${dtoList}">
					<li class="paymentItem">
						<div class="item">

							<div class="order_date">
								<strong>${dto.orderVO.orderDate} 주문</strong>
								<!-- 주문일 -->
							</div>

							<div class="product_content">
								<div class="product_content_list">
									<img alt="상품1"
										src="/kgCoffee/img/menuImg/${dto.paymentsList[0].fileName}">
									<!-- 첫번째 menu_imgurl -->
								</div>

								<div class="product_content_list">
									<div class="content_list_box">
										<h3 class="menu_name">${dto.paymentsList[0].menuName}</h3>
										<!-- 첫번째 상품 이름 -->
										<a class="place_name">${dto.orderVO.placeName}</a>
										<!-- 지점이름 -->
										<a class="order_total">${dto.orderVO.totalPrice}</a>
										<!-- 총 금액 -->
									</div>
								</div>
							</div>

							<div>
								<button type="button" class="btn_order_list"
									onclick="location.href='/kgCoffee/mypage/userOrderView.do?orderId=${dto.orderVO.orderId}'">주문
									상세보기</button>
								<!-- 주문상세페이지로 이동 (orderId 를 가져가서) -->
							</div>


						</div>
						<div class="">
							<ul class="paymentList">
								<c:set var="totalAmount" value=0 />

								<!-- --------------------------------------------------- -->
								<c:forEach var="payments" items="${dto.paymentsList}">

									<li class="orderOneView">
										<div class="itme-one">

											<div class="order_date_view">
												<strong>${dto.orderVO.orderDate}</strong>
											</div>

											<!-- 구입한 상품정보들 -->

											<div class="product_content">
												<div class="product_content_list">
													<img alt="상품1"
														src="/kgCoffee/img/menuImg/${payments.fileName}">
												</div>

												<div class="product_content_list">
													<div class="content_list_box">
														<h3 class="menu_name">${payments.fileName}</h3>
														<!-- 각상품들의 이름 -->
														<a class="order_total">${payments.menuPrice}원</a>
														<!-- 각 상품들의 가격 -->
														<a class="order_total">${payments.menuAmount}개</a>
														<!-- 각상품들의 수량 -->
													</div>
												</div>
											</div>




										</div>
									</li>
									<c:set var="totalAmount"
										value=${totalAmount + payments.menuAmount } />

								</c:forEach>
								<hr class="hr_view">
								<div class="order_total_view">
									<strong>결제 정보</strong><br>
									<h2>지점명 : ${dto.orderVO.placeName}</h2>
									<h2>총 수량 : ${totalAmount }개</h2>
									<h2>총 금액 : ${dto.orderVO.totalPrice}원</h2>
								</div>
							</ul>


						</div>
					</li>
				</c:forEach>
				<!-- --------------------------------------------------- -->

			</ul>

		</div>
		<!-- payment div end -->

	</section>
	<!-- mypage section end -->

	<jsp:include page="../../paging/pagingOrderList.jsp">
		<jsp:param value="${paging.page}" name="page" />
		<jsp:param value="${paging.beginPage}" name="beginPage" />
		<jsp:param value="${paging.endPage}" name="endPage" />
		<jsp:param value="${paging.prev}" name="prev" />
		<jsp:param value="${paging.next}" name="next" />
	</jsp:include>


	<%@include file="../../include/footer.jsp"%>

	<script>
		console.log('${update_msg}');
		const update_msg = '${update_msg}';

		if (update_msg === 'update-success') {
			alert('${loginUser.user_name}' + '님 수정 되었습니다.');
		} else if (update_msg === 'update-failed') {
			alert('${loginUser.user_name}' + '님 수정을 실패했습니다. 다시 입력해주세요.');
			history.back();
		}
	</script>

</body>
</html>
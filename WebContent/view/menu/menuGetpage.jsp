
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
	
	<!--================= 메뉴 리스트 페이지 =======================-->

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
		<div class="box-container">
		
				<c:forEach var='vo' items="${alist}">
					<div class="box">
						<span class="discount">${vo.menuType }</span>
						<div class="image">
							<img
								src="http://localhost:8080/kgCoffee/img/menuImg/${vo.fileName }"
								alt="" />
						</div>
						<div class="content">
							<h3>${vo.menuName }</h3>
							<div class="price">${vo.menuPrice }</div>
						</div>
						
				<!-- <form action="#">	 -->
					<div class="inner_modal">
					    <div class="close_wrap">
							<div class="inner_close" >&times;</div>
						</div>
						<div class="inner_modal_text1"><b>${vo.menuName }</b></div>
						<div class="inner_modal_text2">가격: ${vo.menuPrice }</div>
						<div class="inner_modal_text3">${vo.menuExplain }</div>
						<div class="inner_modal_basket">
							수량: <input type="number" name="num"/>
							<input type="submit" value="장바구니 담기">
						</div>
					</div>
				<!-- </form> -->	
					</div>

					
				</c:forEach> 
			</div>

		
		 	<nav aria-label="Page navigation example">
				<ul class="pagination" id="pagination_ul">
					<c:if test="${paging.prev}">
						<li class="page-item"><a class="page-link"
							href="getAllmenu.do?page=${paging.beginPage-1}&amount=12&displayPage=10"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					
				
			<c:forEach var="n" begin="${paging.beginPage}" 
						end="${paging.endPage}" step="1">
						<li data-page-num="${n}" class="page-item"><a
							class="page-link"
							href="getAllmenu.do?page=${n}&amount=12&displayPage=10">${n}</a>
						</li>
					</c:forEach>
					<c:if test="${paging.next}">
						<li class="page-item"><a class="page-link"
							href="getAllmenu.do?page=${paging.endPage+1}&amount=12&displayPage=10"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>

				</ul>
			</nav> 
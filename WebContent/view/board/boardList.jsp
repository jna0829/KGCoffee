<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

<link rel="stylesheet" href="/kgCoffee/css/board.css">
<link rel="stylesheet" href="/kgCoffee/css/header_style.css" type="text/css">

</head>
<body>

	<%@include file="../../include/header.jsp" %>
	
	<div class="board_wrap">
	
		<div class="board_title">
			<strong><h3 align="center">종로 KG커피 공지사항</h3></strong>
			<p align="center">종로 KG커피 소식을 알려드립니다.</p>
		</div>
		
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="num">번호</div>
					<div class="title">제목</div>
					<div class="writer">글쓴이</div>
					<div class="date">작성일</div>
					<div class="count">조회</div>
				</div>


				<c:forEach var="v1" items="${alist1}">
					<div>
						<div class="num">${v1.bunho}</div>
						<%-- <div class="title"><a href="boardView.jsp"> ${v1.jemok}</a></div> --%>
						<div class="title">
							<a href="/kgCoffee/board/searchone.do?bunho=${v1.bunho}"> ${v1.jemok}</a>
						</div>
						<div class="writer">${v1.writer}</div>
						<%-- <div class="date">${v1.date}</div> --%>
						<div class="date"><fmt:formatDate value="${v1.date }" pattern="yyyy-MM-dd" /></div>
						<div class="count">${v1.count}</div>
					</div>
				</c:forEach>
			</div>
				
				<jsp:include page="../../paging/paging.jsp">
				    <jsp:param value="${paging.page}" name="page"/>
				    <jsp:param value="${paging.beginPage}" name="beginPage"/>
				    <jsp:param value="${paging.endPage}" name="endPage"/>
				    <jsp:param value="${paging.prev}" name="prev"/>
				    <jsp:param value="${paging.next}" name="next"/>
				</jsp:include>
				
				
				<c:choose>
					<c:when test="${sessionScope.result==1}">
						<div class="bt_wrap">
							<a href="/kgCoffee/view/board/boardWrite.jsp" class="on">글쓰기</a>
						</div>
					</c:when>
					<c:otherwise> 
						 
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>

		<%@include file="../../include/footer.jsp" %>
	
</body>
</html>
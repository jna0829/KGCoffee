<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<html>
<head>
<meta charset="UTF-8">
<title>회원관리페이지</title>
<link rel="stylesheet" href="/kgCoffee/css/board.css">
<link rel="stylesheet" href="/kgCoffee/css/header_style.css" type="text/css">
<!--서브밋해주는 자바스크립트 -->
<script type="text/javascript" src="/kgCoffee/js/boardSubmit.js" defer></script>



<!-- html 과 javaScript를 사용하여 checkbox  기능 구현 -->
<!-- HTML 에서 allCheck 라는 ID를 가진 체크박스 있음
$("allCheck").change(function)(){....}은 'allCheck'체크박스의 상태변화를 감지하는 핸들러임
즉, 체크박스를 선택하거나 선택 해제할 때마다 실행됨
체크박스가 선택되었을때('this.checked'가 'true'일때), 
'$(".check")' 클래스를 가진 모든 체크박스의 'checked' 속성을 'true'로 변경함.
이렇게 하면 모든 회원을 선택한 것과 같은 효과가 있음
('this.checked'가 'false'일때), 
'$(".check")'클래스를 가진 모든 체크박스의 'checked'속성을 'false'로 변경함.
이렇게 하면 모든 회원의 선택이 해제된 것과 같은 효과가 있음
'$("#checkForm").submit(function(){...})'은 폼이 제출될 때 실행되는 이벤트 핸들러임
이 이벤트 핸들러는 선택된 회원이 없을 경우 경고창을 표시하고 폼 제출을 막음    
'$("#checkForm").submit(function(){...})'은 폼이 제출될 때 실행되는 이벤트 핸들러임
이 이벤트 핸들러는 선택된 회원이 없을 경우 경고창을 표시하고 폼 제출을 막음
'$(".check").filter(":checked").size()'는 'check'클래스를 가진 체크박스 중 선택된 체크박스의 개수를 반환
'filter(":checked")'는 선택된 체크박스만 필터링하는 역할을 한다
선택된 체크박스의 개수가 0개일 경우 'alert("회원을 한 명도 선택하지 않았습니다.")'가 실행되고,
폼 제출을 막기위해 'return false'를 반환한다 -->

<script>
    $(document).ready(function(){
        $("allCheck").change(function(){
            if(this.checked){
                $(".check").prop("checked", true);
            }else{
                $(".check").prop("checked",false);
            }
            });
        $("#frm2").submit(function(){
           
           if($(".check").filter(":checked").size()==0){
              alert("회원을 한 명도 선택하지 않았습니다.");
              return false;
           }
        });
     });
    
    
 
    
    
</script>


</head>
<body>

   <%@include file="/include/header.jsp"%>

   <div class="board_wrap">
   
      <div class="board_title">
         <strong><h3 align="left">회원관리 페이지</h3></strong>
      </div>
      
      <!----------------------------------- 멤버 검색창 ------------------------------------>

      <form id="frm1" action="/kgCoffee/management/searchMember.do" method="get" enctype="multipart/form-data">
      <ul>
         <div class="board_search_wrap">
               <ul class="board_ul">
                  <li class="board_search_select">
                     <div class="input_select_wrap input_wrap2">
                        <select name="searchKeywordType">
                        <c:choose>
                           <c:when test="${param.searchKeywordType == 'user_id'}">
                              <option value="user_id" selected>아이디</option>
                              <option value="user_name">이름</option>
                              <option value="tel">전화번호</option>
                           </c:when>
                           <c:when test="${param.searchKeywordType == 'user_name'}">
                              <option value="user_id">아이디</option>
                              <option value="user_name"selected>이름</option>
                              <option value="tel">전화번호</option>
                           </c:when>
                              <c:when test="${param.searchKeywordType == 'tel' }">
                              <option value="user_id">아이디</option>
                              <option value="user_name">이름</option>
                              <option value="tel" selected>전화번호</option>
                           </c:when>
                           <c:otherwise>
                              <option value="user_id" selected>아이디</option>
                              <option value="user_name">이름</option>
                              <option value="te">전화번호</option>
                           </c:otherwise>
                        </c:choose>
                        </select> 
                     </div>
                     <div class="input_text_wrap input_wrap2">
                        <label> <input type="text" name="searchKeyword" value="${param.searchKeyword}" placeholder="검색어를 입력하세요" required="required">
                        </label>
                     </div>
                  </li>
                  <li class=bt_wrap>
                  <a href="#" onclick="formSubmit();" class="on">검색</a>
                  <!-- <a href="/kgCoffee/management/deleteMember.do" onclick="formSubmit();" class="on">삭제</a> -->
                  </li>
               </ul>
            </form>
         </div>
      </ul>
      
   <!----------------------------------- 멤버 검색창 ------------------------------------>      
      
   <!--멤버 리스트 -->
      
      <form id="frm2" action="/kgCoffee/management/deleteMember.do" method="get" enctype="multipart/form-data">
         
      <div class="board_list_wrap">
         <div class="board_list">
            <div class="top">
               <div class = "check"><input type="checkbox" id="allCheck"></div>
               <div class = "id">아이디</div>
               <div class = "pass">패스워드</div>
               <div class = "name">이름</div>
               <div class = "birth">생일</div>
               <div class = "tel">전화번호</div>
            </div>
         
               <div>
               <%-- <c:forEach var="li" items="${list}" > --%>
                  <div class="check">
                     <input type="checkbox" class="check" name="checkId" value="${li.user_id}" >
                  </div>
                  <div class="id">
                     <a href="/kgCoffee/management/getOne.do?user_id=${li.user_id}">${li.user_id}</a>
                  </div>
                  <div class="pass">
                     <input type="password" value="${li.user_pw}" readonly>
                  </div>
                  <div class="name">
                     ${li.user_name}
                  </div>
                  <div class="birth">
                     ${li.birthday}
                  </div>
                  <div class="tel">
                     ${li.tel}
                  </div>
             <%--   </c:forEach> --%>
               </div>
               <div>
               <li class= "bt_wrap">
                  <a href="#" onclick="formSubmit()" class="on">삭제</a>
               </li>
               </div>
         </div>
            
            <jsp:include page="../paging/paging4.jsp">
                <jsp:param value="${paging.page}" name="page"/>
                <jsp:param value="${paging.beginPage}" name="beginPage"/>
                <jsp:param value="${paging.endPage}" name="endPage"/>
                <jsp:param value="${paging.prev}" name="prev"/>
                <jsp:param value="${paging.next}" name="next"/>
            </jsp:include>
            
            
            
         </div>
      </div>
         
      </form>
      
</body>
</html>
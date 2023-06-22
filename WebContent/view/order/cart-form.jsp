<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <!--    <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
    <title>Title</title>

    <style>
        /* 테이블 가운데 정렬 */
        table {
            margin-left: auto;
            margin-right: auto;
            width: 80%; /* 테이블 너비 조정 */
        }
        table td {
            text-align: center;
        }
        /* 가운데 정렬 */
        .center-align {
            text-align: center;
        }

    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/kgCoffee/js/basket-form.js"></script>
    <script src="https://kit.fontawesome.com/efb53b9ad1.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="/kgCoffee/css/basket-form.css">
</head>
<body>

<div class="container" style="justify-content: center">
    <h1 style="text-align: center">장바구니</h1>
    <label class="font">주문 상품</label>
    <div class="form-group">
        <c:forEach var="item" items="${baskets}" varStatus="status">
            <div class="product-info" id="ix${status.count}">
                <div>
                    <img src="1.jpg" width="70">
                </div>
                <div style="flex-grow: 1; width: max-content">
                    <div>
                        <div class="product-info-name">${item.product_name}</div>
                        <div class="product-info-count">
                            <span onclick="javascript:basket.changePNum(${status.count}, ${item.basket_id}, ${item.product_price})" style="margin-right: 15px"><i class="fa-solid fa-minus minus"></i></span>
                            <input type="text" name="p_num${status.count}" id="p_num${status.count}" size="2" maxlength="4" class="p_num" value="${item.product_count}" onkeyup="javascript:basket.changePNum(${status.count});">
                            <span onclick="javascript:basket.changePNum(${status.count}, ${item.basket_id}, ${item.product_price})" style="margin-left: 15px"><i class="fa-solid fa-plus plus"></i></span>
                        </div>
                    </div>
                </div>
                <div>
                    <button class="delete_button fa-solid fa-xmark" onclick="javascript:basket.delItem(${status.count}, ${item.basket_id})"></button>
                    <div class="product-info-fee" id="amount${status.count}" style="margin-top: 40px">${item.product_price * item.product_count}원</div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div style="display:flex; margin-top: 50px">
        <p class="font" style="width: 50%">상품 금액</p>
        <p style="width: 50%" class="red" id="sum_p_price">${total_amount_fee}원</p>
    </div>
</div>
<div class="buttons" style="display: flex">
    <form action="order" method="GET">
        <input type="hidden" name="user_id" value=${user_id}>
        <input type="hidden" name="totalPrice" id="totalPrice" value=${total_amount_fee}>
        <button type="submit"  onclick="javascript:basket.go_pay_form()">결제하기</button>
    </form>
    <form action="order" method="GET">
        <button type="submit">뒤로가기</button>
    </form>
</div>
</body>
</html>

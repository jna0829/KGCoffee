<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }
        .font{
            margin-bottom: 10px;
            font-size: 1.25em;
            font-weight: bold;
        }
        .container {
            height: 700px;
            max-height: 700px;
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        textarea,
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        .buttons {
            text-align: center;
            margin-top: 20px;
        }

        button {
            padding: 10px 20px;
            margin-right: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            color: #fff;
            background-color: #007bff;
            cursor: pointer;
        }

        button:hover {
            background-color: #0069d9;
        }
    </style>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script type="text/javascript" src="../resources/js/order-form.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container" style="justify-content: center">
    <h1>주문 상세</h1>
    <div class="form-group">
        <label class="font" for="order-list">주문 상품</label>
        <textarea id="order-list" rows="4" placeholder="주문 상품 내용"></textarea>
    </div>

    <div class="form-group">
        <label class="font" for="request">요청 사항</label>
        <textarea id="request" rows="2" placeholder="요청 사항을 입력하세요"></textarea>
    </div>

    <label class="font">매장 방문 여부</label>
    <div class="form-group">
        <div style="display: flex">
            <input type="radio" id="eat-in" name="visit-type" value="매장 먹고 가기" checked>
            <p for="eat-in">매장에서 먹고 갈게요</p>
        </div>
        <div style="display: flex">
            <input type="radio" id="take-out" name="visit-type" value="포장">
            <p for="take-out">포장해주세요</p>
        </div>
    </div>
    <div>
        <label class="font">결제 수단</label>
        <div class="form-group" style="flex-wrap: wrap; display: flex;">
            <div style="display: flex; width: 50%">
                <input type="radio" id="kakaopay" name="payment-method" value="kakaopay" checked>
                <p for="kakao-pay">카카오페이</p>
            </div>
            <div style="display: flex; width: 50%">
                <input type="radio" id="kcp" name="payment-method" value="kcp">
                <p for="credit-card">신용카드</p>
            </div>
            <div style="display: flex; width: 50%">
                <input type="radio" id="payco" name="payment-method" value="payco">
                <p for="payco">페이코</p>
            </div>
            <div style="display: flex; width: 50%">
                <input type="radio" id="naverpay" name="payment-method" value="naver-pay">
                <p for="naver-pay">네이버페이</p>
            </div>
        </div>
    </div>


    <div style="display:flex; text-align: center; justify-content: center">
        <p class="font">결제 금액: &nbsp</p>
        <p class="font">${totalPrice}</p>
    </div>
</div>
<div class="buttons">
    <button id="pay-button" onclick="javascript:order.go_pay('${user_id}', '${totalPrice}', '${user_id}')">결제하기</button>
    <button id="back-button">뒤로가기</button>
</div>

</body>
</html>
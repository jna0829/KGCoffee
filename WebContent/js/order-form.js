

let order = {
    go_pay : function(n, tp, bn) {
        var paymentMethod = document.querySelector('input[name="payment-method"]:checked').value;
        // 아임포트 API 키 설정
        var IMP = window.IMP;
        // 본인 포트원 IMP 이름
        IMP.init('imp15145348');
        //

        var mapId = $("#"+($("#store_list").val())).data("val");

        console.log(mapId);
        IMP.request_pay({
            pg : paymentMethod,
            pay_method : 'card',
            merchant_uid : 'kg_coffee_' + new Date().getTime(),
            name : n ,
            amount : tp,
            buyer_email : 'iamport@siot.do',
            buyer_name : "kgCoffee",
            buyer_tel : '010-1234-5678',
        }, function(res) {
            if ( res.success ) {
                console.log(res);
                // 결제검증

                // {
                //     apply_num: "42827474",
                //     bank_name: null,
                //     buyer_addr: "서울특별시 강남구 삼성동",
                //     buyer_email: "test@portone.io",
                //     buyer_name: "포트원 기술지원팀",
                //     buyer_postcode: "123-456",
                //     buyer_tel: "010-1234-5678",
                //     card_name: "신한카드",
                //     card_number: "5428790000000294",
                //     card_quota: 0,
                //     currency: "KRW",
                //     custom_data: null,
                //     imp_uid: "imp_347242536261",
                //     merchant_uid: "57008833-33004",
                //     name: "당근 10kg",
                //     paid_amount: 1004,
                //     paid_at: 1648344363,
                //     pay_method: "card",
                //     pg_provider: "kcp",
                //     pg_tid: "22336466628585",
                //     pg_type: "payment",
                //     receipt_url: "https://admin8.kcp.co.kr/assist/bill.BillActionNew.do?cmd=card_bill&tno=22336466628585&order_no=imp_347242536261&trade_mony=1004",
                //     status: "paid",
                //     success: true
                // }
                console.log(res.status);
                $.ajax({
                    type : "POST",
                    url : "/kgcoffee/order/complete",
                    data : {
                        // 저장할 pay 정보 넣어서 서버 보내서 DB 테이블 저장
                        imp_uid : res.imp_uid,
                        paid_amount : res.paid_amount,
                        pay_method : res.pay_method,
                        pg_provider : res.pg_provider,
                        paid_at : res.paid_at,
                        card_name : res.card_name,
                        map_id : mapId


                    }
                }).done(function(res_data) {

                    // view 페이지 전환
                    // 결제 검증이 제외됐기때문에 href 바로 complete 화면 이동


                });
            }
        });

        // 아임포트 결제 요청
        IMP.request_pay(paymentInfo, function(response) {
            if (response.success) {
                // 결제 성공 시 동작
                console.log('결제가 완료되었습니다.');
                console.log(response);
            } else {
                // 결제 실패 시 동작
                console.log('결제에 실패하였습니다.');
                console.log('error_code : '+response.error_code);
                console.log('error_msg : '+response.error_msg);
                console.log(response);
            }
        });
    },
}

$("#back-button").click(function(){

    history.back();

})
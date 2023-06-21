

let order = {
    go_pay : function(n, tp, bn) {
        var paymentMethod = document.querySelector('input[name="payment-method"]:checked').value;
        // 아임포트 API 키 설정
        var IMP = window.IMP;
        // 본인 포트원 IMP 이름
        IMP.init('imp15145348');
        //
        IMP.request_pay({
            pg : paymentMethod,
            pay_method : 'card',
            merchant_uid : 'kg_coffee_' + new Date().getTime(),
            name : n ,
            amount : tp,
            buyer_email : 'iamport@siot.do',
            buyer_name : bn,
            buyer_tel : '010-1234-5678',
        }, function(res) {
            if ( res.success ) {
                console.log(res);
                // 결제검증
                $.ajax({
                    type : "POST",
                    url : "order/complete",
                    data : {
                        // 저장할 pay 정보 넣어서 서버 보내서 DB 테이블 저장
                        imp_uid : res.imp_uid,
                        paid_amount : res.paid_amount
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
                console.log(response);
            }
        });
    },
}
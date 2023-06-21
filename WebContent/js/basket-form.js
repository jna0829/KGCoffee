let basket = {
    totalCount: 0,
    totalPrice: 0,
    //재계산
    reCalc: function(){
        this.totalCount = 0;
        this.totalPrice = 0;
        $("[id^='amount']").each((index, element) => {
            var price = $(element).text();
            price = price.substring(0, price.length-1)
            price *= 1
            this.totalPrice += price;
            ttp =  this.totalPrice;
        });
    },
    //화면 업데이트
    updateUI: function () {
        $('#sum_p_price').text(this.totalPrice + "원");
    },
    //개별 수량 변경
    changePNum: function (pos, bi, pr) {
        var item = document.querySelector('input[name=p_num'+pos+']');
        var p_num = parseInt(item.getAttribute('value'));
        var new_val = event.target.classList.contains('plus') ? p_num+1 : event.target.classList.contains('minus') ? p_num-1 : event.target.value;
        if (parseInt(new_val) < 1 || parseInt(new_val) > 99) { return false; }

        item.setAttribute('value', new_val);
        item.value = new_val;

        //AJAX 업데이트 전송
        $.ajax({
            url: "basket/update",
            type: "post",
            data : {
                basket_id: bi,
                new_val : new_val
            },
            success: function (response){
                console.log("delete success")
            },
            error: function (xhr, status, error){
                console.log("delete fail")
            }


        })

        // ui UPDATE
        $("#amount"+pos).text((new_val * pr) + "원");
        this.reCalc();
        this.updateUI();
    },
    delItem: function (pos, bi) {
        //AJAX 서버 업데이트 전송
        $.ajax({
            url: "basket/delete",
            type: "post",
            data : {
                basket_id : bi
            },
            success: function (response){
                console.log("delete success")
            },
            error: function (xhr, status, error){
                console.log("delete fail")
            }
        })

        // ui UPDATE
        $("#ix"+pos).remove();
        this.reCalc();
        this.updateUI();
    },
    go_pay_form: function() {
        this.reCal().then(function(ttp) {
            console.log(ttp);
            var totalPriceInput = document.getElementById("totalPrice");
            totalPriceInput.value = ttp;
        });
    },

    reCal: function() {
        return new Promise(function(resolve) {
            this.totalCount = 0;
            this.totalPrice = 0;
            var ttp = 0;
            $("[id^='amount']").each((index, element) => {
                var price = $(element).text();
                price = price.substring(0, price.length-1)
                price *= 1
                this.totalPrice += price;
            });
            ttp = this.totalPrice;
            resolve(ttp);
        });
    }
}

// let btn = {
//
//
//     // 뒤로가기
//     go_back_form: function(){
//     }
// }


window.addEventListener("load", function() {
    // 실행할 함수 호출
    basket.reCalc();
    basket.updateUI();
    console.log(basket.totalPrice)
});

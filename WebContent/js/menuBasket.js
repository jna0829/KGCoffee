/**
 * 
 */


//장바구니 클릭 이벤트
$(".basket_btn").click(menuBasket);

console.log("시작");


function menuBasket() {

	var reqUrl = "/kgCoffee/order/cart/insert";
	var vo = $(this).parent().data("vo", "menuId");
	var amount = $(this).prev().val();


	console.log($(this).parent().data("vo", "menuId"));
	console.log($(this).prev().val());
	console.log(vo);
	console.log(amount);

/*	$.ajax({
		url: reqUrl,
		type: "POST",
		data: 'JSON',
		success: function(data) {


			console.log(data);


		}


	})*/
}

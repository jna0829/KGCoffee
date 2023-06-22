/**
 * 
 */


//장바구니 클릭 이벤트
$(".basket_btn").click(menuBasket);

console.log("시작");


function menuBasket() {

	var reqUrl = "/kgCoffee/order/cart/insert";
	var menuId = $(this).parent().data("vo", "menuId");
	var amount = $(this).prev().val();

	console.log(menuId);
	console.log(amount);

	$.ajax({
		url: reqUrl,
		type: "POST",
		data: {

			menuId : menuId,
			menuAmount: amount


		},
		success: function(data) {


			console.log(data);


		}


	})
}

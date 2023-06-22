/**
 * 
 */
$(function(){
	
	//장바구니 클릭 이벤트
	$(".basket_btn").click(menuBasket);



	function menuBasket(){
	
	var reqUrl = "/kgCoffee/order/cart/insert";
	var vo =  $(this).parent().data("vo","menuId");
	var amount = $(this).prev().val();
	
	/*console.log(JSON.parse(vo));*/

	/*console.log($(this).parent());
	console.log($(this).prev());
	console.log(vo);
	console.log(amount);*/
	
	$.ajax({
			url : reqUrl,
			type : "POST",
			data : 'JSON',
			success : function(vo) {
						

	
	}
		
	
}) 
		}})
	
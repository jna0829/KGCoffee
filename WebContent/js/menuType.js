/**
 * 
 */

	/*메뉴리스트 비동기처리*/

$(".text > input").change(searchEvent);
	
	
	function searchEvent(){
		

		var reqUrl = "/kgCoffee/menu/getSerchmenu.do?page=1&amount=12&displayPage=10";

		$("input:checkbox").each(function(index) {
			if ($(this).is(":checked") == true) {

				
				console.log($(this));
				console.log($(this).data("type"));
			
				 reqUrl += "&"+$(this).data("type") + "=" + $(this).data("value");
				 
				 
				
			}

		})
		console.log(reqUrl);
		
			
				var newEl = "";
				
				$
				.ajax({
					url : reqUrl,
					type : "GET",
					data : 'JSON',
					success : function(data) {
						
						
						
						
						console.log(data)
						
						var newEl = data;
						console.log($("div.page_wrap"));
						
						
						$("div.page_wrap").html(data.toString());
						
						
						console.log("종료");
						

			}})


	} 
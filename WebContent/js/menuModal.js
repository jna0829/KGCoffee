/**
 * 
 */

			/*모달창 클릭 이벤트*/

	  $(".box").click(function (event) {

         event.stopPropagation();
			console.log($(this));
		console.log($(this).children(".inner_modal"));

         $(this).children(".inner_modal").addClass("active")


      });

      $(".inner_close").click(function (event) {

         event.stopPropagation();
         event.preventDefault();
         var $modal = $(this).parent().parent();



         $modal.removeClass("active");


      });
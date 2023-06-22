package com.kgcoffee.web.order.controller.cart;

import java.util.ArrayList;
import java.util.Map;

import com.kgcoffee.web.order.Controller;
import com.kgcoffee.web.order.dao.CartRepository;
import com.kgcoffee.web.order.domain.CartVO;

public class CartInsertController implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {

		String result="fail";

		int menuId = Integer.parseInt(paramMap.get("menu_id"));
		String userId = paramMap.get("user_id");
		int menuAmount = Integer.parseInt(paramMap.get("menu_amount"));
		CartRepository CartRepository = new CartRepository();
		
		int cartId= CartRepository.findCartByMenuId(userId, menuId);
		if ( cartId >= 1) {
			CartRepository.update(cartId, menuAmount);
			
			result="update-sucess";

		}else {
			
			CartVO cart = new CartVO(menuId,userId,menuAmount);
			CartRepository.save(cart);
			
			result="create-sucess";
			
		}
		
		model.put("cart-msg", result);

		return "insert-cart-result";
	}

		
	

}

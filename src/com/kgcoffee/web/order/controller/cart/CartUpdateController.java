package com.kgcoffee.web.order.controller.cart;

import java.util.ArrayList;
import java.util.Map;

import com.kgcoffee.web.order.Controller;
import com.kgcoffee.web.order.dao.CartRepository;
import com.kgcoffee.web.order.domain.CartVO;

public class CartUpdateController implements Controller {

	@Override
	public String process(Map<String, Object> paramMap, Map<String, Object> model) {
		
		
		int cartId = (Integer)(paramMap.get("cart_id"));
	
		String userId = (String) paramMap.get("user_id");
		int menuAmount = (Integer)(paramMap.get("menu_amount"));
		CartRepository CartRepository = new CartRepository();

		CartRepository.update(cartId, menuAmount);
		ArrayList<CartVO> CartList = CartRepository.findAllCartsByUserId(userId);
		model.put("carts", CartList);

		return "Cart-form";
	}
}

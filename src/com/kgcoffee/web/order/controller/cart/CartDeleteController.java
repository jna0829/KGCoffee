package com.kgcoffee.web.order.controller.cart;

import java.util.ArrayList;
import java.util.Map;

import com.kgcoffee.web.order.Controller;
import com.kgcoffee.web.order.dao.CartRepository;
import com.kgcoffee.web.order.domain.CartVO;


public class CartDeleteController implements Controller {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        paramMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        int cartId = Integer.parseInt(paramMap.get("cart_id"));
        String userId = paramMap.get("user_id");
        CartRepository cartRepository = new CartRepository();
        cartRepository.delete(cartId);
        ArrayList<CartVO> cartDtos = cartRepository.findAllCartsByUserId(userId);
        model.put("carts", cartDtos);
        return "cart-form";
    }
}

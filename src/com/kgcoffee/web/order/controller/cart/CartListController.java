package com.kgcoffee.web.order.controller.cart;

import java.util.ArrayList;
import java.util.Map;

import com.kgcoffee.web.order.Controller;
import com.kgcoffee.web.order.dao.CartRepository;
import com.kgcoffee.web.order.domain.CartVO;
import com.kgcoffee.web.order.service.CartService;

public class CartListController implements Controller {

    public CartService cartService = new CartService();

    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> model) {
        // user data 없어서 임시로 test 바로 보냄 후에 paramMap에서 받아오는 것으로 수정
        CartRepository cartRepository = new CartRepository();
        
        String userId = (String) paramMap.get("user_id");
        ArrayList<CartVO> cartList = cartRepository.findAllCartsByUserId(userId);
        int totalAmountByUser = cartService.getTotalAmountByUser(cartList);
        model.put("total_amount_fee", totalAmountByUser);
        model.put("carts", cartList);
        model.put("user_id", "test");

        return "cart-form";
    }
}

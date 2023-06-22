package com.kgcoffee.web.order.service;

import java.util.ArrayList;

import com.kgcoffee.web.order.domain.CartVO;

public class CartService {

    public int getTotalAmountByUser(ArrayList<CartVO> cartList){
        int tmp = 0;
        for (CartVO cart: cartList) {
            tmp += (cart.getMenuAmount() * cart.getMenuPrice());
        }
        return tmp;
    }
}

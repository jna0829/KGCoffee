package com.kgcoffee.web.order.service;

import java.util.ArrayList;

import com.kgcoffee.web.order.domain.basket.BasketDto;

public class BasketService {

    public int getTotalAmountByUser(ArrayList<BasketDto> basketDtos){
        int tmp = 0;
        for (BasketDto b: basketDtos) {
            tmp += (b.getProduct_count() * b.getProduct_price());
        }
        return tmp;
    }
}

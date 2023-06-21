package com.kgcoffee.web.order.controller.basket;

import java.util.ArrayList;
import java.util.Map;

import com.kgcoffee.web.order.Controller;
import com.kgcoffee.web.order.domain.basket.BasketDto;
import com.kgcoffee.web.order.domain.basket.BasketRepository;
import com.kgcoffee.web.order.service.BasketService;

public class BasketListController implements Controller {

    public BasketService basketService = new BasketService();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        // user data 없어서 임시로 test 바로 보냄 후에 paramMap에서 받아오는 것으로 수정
        BasketRepository basketRepository = new BasketRepository();
        ArrayList<BasketDto> basketDtos = basketRepository.findAllBasketsByUserId();
        int totalAmountByUser = basketService.getTotalAmountByUser(basketDtos);
        model.put("total_amount_fee", totalAmountByUser);
        model.put("baskets", basketDtos);
        model.put("user_id", "test");

        return "basket-form";
    }
}

package com.kgcoffee.web.order.controller.basket;

import java.util.ArrayList;
import java.util.Map;

import com.kgcoffee.web.order.Controller;
import com.kgcoffee.web.order.domain.basket.BasketDto;
import com.kgcoffee.web.order.domain.basket.BasketRepository;


public class BasketDeleteController implements Controller {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        paramMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        int basket_id = Integer.parseInt(paramMap.get("basket_id"));
        BasketRepository basketRepository = new BasketRepository();
        basketRepository.delete(basket_id);
        ArrayList<BasketDto> basketDtos = basketRepository.findAllBasketsByUserId();
        model.put("baskets", basketDtos);
        return "basket-form";
    }
}

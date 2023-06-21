package hello.servlet.web.frontcontroller.kgcoffee.controller.basket;

import hello.servlet.domain.basket.BasketDto;
import hello.servlet.domain.basket.BasketRepository;
import hello.servlet.web.frontcontroller.kgcoffee.Controller;

import java.util.ArrayList;
import java.util.Map;

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

package hello.servlet.web.frontcontroller.kgcoffee.controller.basket;

import hello.servlet.domain.basket.BasketDto;
import hello.servlet.domain.basket.BasketRepository;
import hello.servlet.web.frontcontroller.kgcoffee.Controller;

import java.util.ArrayList;
import java.util.Map;

public class BasketUpdateController implements Controller {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        int basket_id = Integer.parseInt(paramMap.get("basket_id"));
        int new_val = Integer.parseInt(paramMap.get("new_val"));
        BasketRepository basketRepository = new BasketRepository();
        basketRepository.update(basket_id, new_val);
        ArrayList<BasketDto> basketDtos = basketRepository.findAllBasketsByUserId();
        model.put("baskets", basketDtos);

        return "basket-form";
    }
}

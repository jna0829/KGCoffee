package hello.servlet.web.frontcontroller.kgcoffee.controller.basket;

import hello.servlet.domain.basket.BasketDto;
import hello.servlet.domain.basket.BasketRepository;
import hello.servlet.web.frontcontroller.kgcoffee.Controller;
import hello.servlet.web.frontcontroller.kgcoffee.service.BasketService;

import java.util.ArrayList;
import java.util.Map;

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

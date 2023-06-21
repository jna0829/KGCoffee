package hello.servlet.web.frontcontroller.kgcoffee.service;

import hello.servlet.domain.basket.BasketDto;

import java.util.ArrayList;

public class BasketService {

    public int getTotalAmountByUser(ArrayList<BasketDto> basketDtos){
        int tmp = 0;
        for (BasketDto b: basketDtos) {
            tmp += (b.getProduct_count() * b.getProduct_price());
        }
        return tmp;
    }
}

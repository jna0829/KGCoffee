package com.kgcoffee.web.order.controller.order;

import java.util.Map;

import com.kgcoffee.web.order.Controller;

public class OrderController implements Controller {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        model.put("userId", paramMap.get("userId"));
        model.put("totalPrice", paramMap.get("totalPrice"));
        return "order-form";
    }
}

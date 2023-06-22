package com.kgcoffee.web.order.controller.order;

import java.util.Map;

import com.kgcoffee.web.order.Controller;

public class OrderController implements Controller {
    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> model) {
        model.put("user_id", paramMap.get("user_id"));
        model.put("totalPrice", paramMap.get("totalPrice"));
        return "order-form";
    }
}

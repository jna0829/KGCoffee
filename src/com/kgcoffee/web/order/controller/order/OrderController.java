package hello.servlet.web.frontcontroller.kgcoffee.controller.order;

import hello.servlet.web.frontcontroller.kgcoffee.Controller;

import java.util.Map;

public class OrderController implements Controller {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        model.put("user_id", paramMap.get("user_id"));
        model.put("totalPrice", paramMap.get("totalPrice"));
        return "order-form";
    }
}

package com.kgcoffee.web.order.controller.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.kgcoffee.web.order.Controller;

public class OrderCompleteController implements Controller {

//    private ObjectMapper objectMapper;

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		// DB TABLE 생성해서 주문 정보 원하는 값들만 넣어주면 됨.

		long timestamp = Long.parseLong(paramMap.get("paid_at"));
		Date pDate = new java.util.Date(timestamp * 1000L);


		return "result-form";
	}
}

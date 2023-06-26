package com.kgcoffee.web.order.controller.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kgcoffee.web.order.Controller;
import com.kgcoffee.web.order.dao.CartRepository;
import com.kgcoffee.web.order.dao.OrderDAO;
import com.kgcoffee.web.order.domain.OrderVO;

public class OrderCompleteController implements Controller {

//    private ObjectMapper objectMapper;

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		// DB TABLE 생성해서 주문 정보 원하는 값들만 넣어주면 됨.

		String result = "order-complete-fail";

		String userId = paramMap.get("userId");
		int paidAt = Integer.parseInt(paramMap.get("paid_at"));
		int totalPrice = Integer.parseInt(paramMap.get("total_price"));
		int mapId = Integer.parseInt(paramMap.get("map_id"));

		long timestamp = Long.parseLong(paramMap.get("paid_at"));
		Date pDate = new java.util.Date(timestamp * 1000L);

		OrderDAO dao = new OrderDAO();
		CartRepository cartDao = new CartRepository();

		if (paidAt == totalPrice) {

			OrderVO order = new OrderVO();

			order.setUserId(userId);
			order.setMapId(mapId);
			order.setTotalPrice(paidAt);
			order.setOrderDate(pDate);

			if (dao.insertOrder(order)) {
				
				Map<String, Object> keyMap = new HashMap<String, Object>();

				keyMap.put("type", "userId");
				keyMap.put("value", userId);

				cartDao.delete(keyMap);
				
				
				result = "order-complete";
			}

		}

		model.put("res-msg", result);

		return "result-form";
	}
}

package test.com.kgcoffee.web.menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.order.controller.cart.CartInsertController;
import com.kgcoffee.web.order.controller.order.OrderCompleteController;

class TestOrderComplete {

	@Test
	void test() {
		

		OrderCompleteController order = new OrderCompleteController();
		
		
		
		Map<String, String> paramMap =  new HashMap<String, String>();
		
	
		Map<String, Object> model = new ConcurrentHashMap<>();
				
		for(int i=0; i<30; i++) {
			
			
			
			CartInsertController insert = new CartInsertController();
			
			
			
			Map<String, String> paramMap2 =  new HashMap<String, String>();
			
		
			Map<String, Object> model2 = new ConcurrentHashMap<>();
					
			for(int j=0; j<10; j++) {
			paramMap2.put("userId", "lee02");
			paramMap2.put("menuId", ""+i);
			paramMap2.put("menuAmount",""+i);
			
			
			insert.process(paramMap2, model2);
			}
			
		paramMap.put("userId", "lee02");
		paramMap.put("paid_at", ""+1554181801);
		paramMap.put("paid_amount",""+(i*1000));
		paramMap.put("total_price",""+(i*1000));
		paramMap.put("map_id",""+1513915761);

		order.process(paramMap, model);
		}
		
		
		
		
		
		
	}

}

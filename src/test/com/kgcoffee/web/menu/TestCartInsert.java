package test.com.kgcoffee.web.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.order.controller.cart.CartInsertController;

class TestCartInsert {

	@Test
	void test() {
		
		CartInsertController insert = new CartInsertController();
		
		
		
		Map<String, String> paramMap =  new HashMap<String, String>();
		
	
		Map<String, Object> model = new ConcurrentHashMap<>();
				
		for(int i=0; i<10; i++) {
		paramMap.put("userId", "lee02");
		paramMap.put("menuId", ""+i);
		paramMap.put("menuAmount",""+i);
		
		
		insert.process(paramMap, model);
		}
		
		
		
	}

}

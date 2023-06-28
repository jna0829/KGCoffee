package test.com.kgcoffee.web.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.admin.DTO.ReportMenuDTO;
import com.kgcoffee.web.order.controller.cart.CartInsertController;

class TestCartInsert {

	@Test
	void test() {
		
//		CartInsertController insert = new CartInsertController();
//		
//		
//		
//		Map<String, String> paramMap =  new HashMap<String, String>();
//		
//	
//		Map<String, Object> model = new ConcurrentHashMap<>();
//				
//		for(int i=0; i<10; i++) {
//		paramMap.put("userId", "lee02");
//		paramMap.put("menuId", ""+i);
//		paramMap.put("menuAmount",""+i);
//		
//		
//		insert.process(paramMap, model);
//		}
		
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		ArrayList<ReportMenuDTO> menuDTOList = new ArrayList<ReportMenuDTO>();

		resMap.put("test", menuDTOList);
		ReportMenuDTO dto = new ReportMenuDTO();
		
		dto.setAgeGroup("블라블라");
		
		menuDTOList.add(dto);
		
		System.out.println(resMap.size());
		
		System.out.println(((ArrayList<ReportMenuDTO>)resMap.get("test")).get(0));
		System.out.println(resMap.size());
		
		
		
//		
		
		
	}

}

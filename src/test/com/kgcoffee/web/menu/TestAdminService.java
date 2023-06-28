package test.com.kgcoffee.web.menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.admin.service.AdminService;

class TestAdminService {

	AdminService service = new AdminService();
	@Test
	void testOrderByAgeGroup() {
		

		
		Map<String, String> keyMap = new HashMap<String, String>();
		
		
		keyMap.put("rank", "3");
		keyMap.put("dateType","YYYY");
		keyMap.put("dateValue", "2023");
		keyMap.put("page", "1");
		
		
		Map<String, Object> model = service.reportOrderByAgeGroup(keyMap);


		
	
		if(model!=null) {
	        model.forEach((key, value) -> System.out.println(key+value));
	    	}
		
		
		
	}

	@Test
	void testOrderByMenu() {
		
		
		
		
		
		
		Map<String, String> keyMap = new HashMap<String, String>();
		
		
		keyMap.put("rank", "3");
		keyMap.put("dateType","YYYY");
		keyMap.put("dateValue", "2023");
		
		
		
		Map<String, Object> model = service.reportOrderByMenu(keyMap);


	
	
		if(model!=null) {
	        model.forEach((key, value) -> System.out.println(key+value));
	    	}
		
		
		
	}
	
	@Test
	void testOrderByMap() {
		

		
		Map<String, String> keyMap = new HashMap<String, String>();
		
		
		
		keyMap.put("dateType","YYYY");
		keyMap.put("dateValue", "2023");
		keyMap.put("page", "1");
		
		
		Map<String, Object> model = service.reportOrderByAgeGroup(keyMap);


		
	
		if(model!=null) {
	        model.forEach((key, value) -> System.out.println(key+value));
	    	}
		
		
		
	}
	
	

}

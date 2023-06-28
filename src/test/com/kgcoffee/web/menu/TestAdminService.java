package test.com.kgcoffee.web.menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.admin.service.AdminService;

class TestAdminService {

	@Test
	void test() {
		
		
		AdminService service = new AdminService();
		
		
		
		Map<String, String> keyMap = new HashMap<String, String>();
		
		
		keyMap.put("rank", "3");
		keyMap.put("dateType","YYYY");
		keyMap.put("dateValue", "2023");
		keyMap.put("page", "1");
		
		
		Map<String, Object> model = service.reportOrderByAgeGroup(keyMap);


		System.out.println(model.size());
	
		if(model!=null) {
	        model.forEach((key, value) -> System.out.println(key+value));
	    	}
		
		
		
	}

}

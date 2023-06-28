package com.kgcoffee.web.admin.service;

import java.util.Map;

import com.kgcoffee.web.admin.dao.AdminDAO;
import com.kgcoffee.web.common.Paging;

public class AdminService {
	
	
	private AdminDAO dao = AdminDAO.getInstance();
	
	
	
	
	
	public Map<String, Object> reportOrderByMap(Map<String, String> keyMap) {
		
		
		System.out.println("reportOrderByMap");
		System.out.println(keyMap.size());
		
		if(!keyMap.containsKey("keywords")) {
			
			keyMap.put("keywords", "");
			
		}
		
		
		Paging paging = makePage(keyMap);
		
		
		
		
		Map<String, Object> resMap =null;
		resMap = dao.findOrderByMap(keyMap);
		resMap.put("paging", paging);
		
		
		return resMap;
	}
	
	

	
	public Map<String, Object> reportOrderByMenu(Map<String, String> keyMap) {
		
		
		System.out.println("reportOrderByMenu");
		System.out.println(keyMap.size());
		
		if(!keyMap.containsKey("manu_name")) {
		
			keyMap.put("menu_name", "");
			
		}
		
		
		Paging paging = makePage(keyMap);		
		
		
		Map<String, Object> resMap =null;
		
		resMap = dao.findOrderByMenu(keyMap);
		resMap.put("paging", paging);
		
		
		return resMap;
	}


	public Map<String, Object> reportOrderByAgeGroup(Map<String, String> keyMap) {
		// TODO Auto-generated method stub
		
		System.out.println("reportOrderByAgeGroup");
		System.out.println(keyMap.size());
		
		Map<String, Object> resMap =null;
		
	
		Paging paging = makePage(keyMap);
		
		
		
		resMap = dao.findOrderByAgeGroup(keyMap);
		resMap.put("paging", paging);
		
		
		return resMap;
	}

	
	public Paging makePage(Map<String, String> keyMap) {
		
		
		int page = 1;
		int amount =10;
		
		
		if(keyMap.containsKey("page")) {
		
			
			page=Integer.parseInt(keyMap.get("page"));
			
		}
		if(keyMap.containsKey("amount")) {
			
			amount=Integer.parseInt(keyMap.get("amount"));
			
		};
		keyMap.put("page", ""+page);
		keyMap.put("amount", ""+amount);
		
		int totalCnt = dao.findOrderByAgeGroupTotalCnt(keyMap);
		
		Paging paging = new Paging();
		
		paging.setPage(page);
		paging.setDisplayRow(amount);
		paging.setTotalCount(totalCnt);
		
		return paging;
		
		
	}

}

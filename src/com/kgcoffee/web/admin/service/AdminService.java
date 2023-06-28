package com.kgcoffee.web.admin.service;

import java.util.Map;

import com.kgcoffee.web.admin.dao.AdminDAO;
import com.kgcoffee.web.common.Paging;

public class AdminService {
	
	
	private AdminDAO dao = AdminDAO.getInstance();
	
	
	
	
	
	public Map<String, Object> reportOrderByMap(Map<String, String> keyMap) {
		
		
		System.out.println("reportOrderByMap");
		System.out.println(keyMap.size());
		
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
		int totalCnt = dao.findOrderByMapTotalCnt(keyMap);
		
		Paging paging = new Paging();
		
		paging.setPage(page);
		paging.setDisplayRow(amount);
		paging.setTotalCount(totalCnt);
		
		
		Map<String, Object> resMap =null;
		resMap = dao.findOrderByMap(keyMap);
		resMap.put("paging", paging);
		
		
		return resMap;
	}
	
	

	
	public Map<String, Object> reportOrderByMenu(Map<String, String> keyMap) {
		
		
		System.out.println("reportOrderByMenu");
		System.out.println(keyMap.size());
		
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
		int totalCnt = dao.findOrderByMenuTotalCnt(keyMap);
		
		Paging paging = new Paging();
		
		paging.setPage(page);
		paging.setDisplayRow(amount);
		paging.setTotalCount(totalCnt);
		
		
		
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
		
		
		
		resMap = dao.findOrderByAgeGroup(keyMap);
		resMap.put("paging", paging);
		
		
		return resMap;
	}

	
	

}

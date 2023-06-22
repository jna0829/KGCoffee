package com.kgcoffee.web.menu.menuAction;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.common.Paging;
import com.kgcoffee.web.menu.menuDAO.MenuDAO;
import com.kgcoffee.web.menu.menuVO.MenuVO;

public class MenuSerch implements MenuImpl{

	@Override
	public void menuAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		MenuDAO mdao;
		try {
			mdao = new MenuDAO();
			
			
		String menuType = request.getParameter("menuType");
		String caffeineType = request.getParameter("caffeineType");
		int page = Integer.parseInt(request.getParameter("page"));
		int displayRow = Integer.parseInt(request.getParameter("amount"));
		int displayPage = Integer.parseInt(request.getParameter("displayPage"));
		Paging paging = new Paging();
		
		if(caffeineType == null) {
			caffeineType = "";
		}
		
		if(menuType == null) {
			menuType = "";
		}
		
		
		if(page>=0) {
			paging.setPage(page);
			
		}
		
		if(displayRow>=0) {
			
			paging.setDisplayRow(displayRow);
			
		}else {
			paging.setDisplayRow(12);
			displayRow=12;
		}
		
		ArrayList<MenuVO> alist = mdao.getInfoMenu(caffeineType, menuType, page, displayRow);
	
		
		int totalCount = mdao.totalCnt();
	
		paging.setDisplayPage(displayPage);
		
		paging.setTotalCount(totalCount);
		
		request.setAttribute("alist", alist);
		request.setAttribute("paging", paging);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

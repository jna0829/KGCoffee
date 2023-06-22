package com.kgcoffee.web.menu.menuAction;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.common.Paging;
import com.kgcoffee.web.menu.menuDAO.MenuDAO;
import com.kgcoffee.web.menu.menuVO.MenuVO;

public class MenugetAllPage implements MenuImpl{

	@Override
	public void menuAction(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		
		
		
		
		response.setCharacterEncoding("UTF-8");
		
		MenuDAO mdao;
		try {
			mdao = new MenuDAO();
	
		Paging paging = new Paging();
		
		int page = Integer.parseInt(request.getParameter("page"));
		int displayRow = Integer.parseInt(request.getParameter("amount"));
		int displayPage = Integer.parseInt(request.getParameter("displayPage"));
		
		
		
		if(page>=0) {
			paging.setPage(page);
			
		}
		
		if(displayRow>=0) {
			
			paging.setDisplayRow(displayRow);
			
		}else {
			paging.setDisplayRow(12);
			displayRow=12;
		}
	
		
		int totalCount = mdao.totalCnt();
	
		paging.setDisplayPage(displayPage);
		
		paging.setTotalCount(totalCount);
		

		
		ArrayList<MenuVO> alist = mdao.getMenuListByPage(paging.getPage(), displayRow);
		
		System.out.println();

		System.out.println(paging);
		
		System.out.println("aList : "+alist);
		
	
		
		request.setAttribute("alist", alist);
		request.setAttribute("paging", paging);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

package com.kgcoffee.web.menu.menuAction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.menu.menuDAO.MenuDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MenuUpdate implements MenuImpl{

	@Override
	public void menuAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=utf-8");
		
		String img = "img/menuImg";
		ServletContext context = request.getServletContext();
		String saveImg = context.getRealPath(img);
		
		MultipartRequest mr = new MultipartRequest(request, saveImg, 1024*1024*10,
				"UTF-8", new DefaultFileRenamePolicy());
		
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		String menuImg = mr.getFilesystemName("img");
		String caffeineType = request.getParameter("caffeineType");
		String menuName = request.getParameter("menuName");
		int menuPrice = Integer.parseInt(request.getParameter("menuPrice"));
		String menuExplain = request.getParameter("menuExplain");
		String menuType = request.getParameter("menuType");
		
		MenuDAO mdao = new MenuDAO();
		mdao.updateMenu(menuId, menuImg, caffeineType, menuName, menuPrice, 
				menuExplain, menuType);
		
	}
	
}

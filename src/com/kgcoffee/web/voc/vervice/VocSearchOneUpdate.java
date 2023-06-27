package com.kgcoffee.web.voc.vervice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kgcoffee.web.voc.dao.VocDAO;
import com.kgcoffee.web.voc.vo.VocVO;

public class VocSearchOneUpdate implements VocImpli{


	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		VocDAO sdao1 = new VocDAO();
		int bunho = Integer.parseInt(request.getParameter("bunho"));
		
		String v_name = (String)request.getParameter("v_name");

		VocVO sv1 = sdao1.searchOneUpdate(bunho);
		
		int result = 0;
		
		String user_id = request.getParameter("user_id");
			
		
		if(sv1.getWriter().equals(v_name)) {
			result = 1;
		} else if (user_id.equals("admin")) {
			result = 2;
		} else {
			result = 3;
		} 
		request.setAttribute("result", result);
		
	}

}

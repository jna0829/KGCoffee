package com.kgcoffee.web.board.controller;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.board.dao.SnsDAO;
import com.kgcoffee.web.board.vo.SnsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class HaevaSearchone implements com.kgcoffee.web.common.ControllerImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		SnsDAO sdao1 = new SnsDAO();
		int bunho = Integer.parseInt(request.getParameter("bunho"));

		SnsVO sv1 = sdao1.searchOne(bunho);

		request.setAttribute("ssv", sv1);
		
	}

}

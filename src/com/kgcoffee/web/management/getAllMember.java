package com.kgcoffee.web.management;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.users.vo.UsersVO;

public class getAllMember implements com.kgcoffee.web.common.ControllerImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		MemberDAO mdao = null;
		ArrayList<UsersVO> list = null;
		
		try {
			mdao = new MemberDAO();
			list = mdao.getAllMember();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("list", list);
		
		
		
	}

}

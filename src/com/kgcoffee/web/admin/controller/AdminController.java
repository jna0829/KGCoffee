package com.kgcoffee.web.admin.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgcoffee.web.admin.service.AdminService;

import com.kgcoffee.web.common.ControllerImpl;
import com.kgcoffee.web.order.MyView;
import com.kgcoffee.web.users.vo.UsersVO;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> keyMap = createParamMap(request);

		Map<String, Object> model = null;

		HttpSession session = request.getSession();
		UsersVO loginUser = ((UsersVO) session.getAttribute("loginUser"));
		String userId = "";
		String str="";
		String c = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(c);

//		if (loginUser != null) {
//			userId = loginUser.getUser_id();
//
//			if (userId == "admin") {

		AdminService service = new AdminService();

		switch (c) {

		case "/admin/getOrderReport":
			str="adminOrderData";
			
			break;
			
		case "/admin/getAllMember.do":
			
			
			model= service.getAllMember(keyMap);
			
			
			str = "memberlistttttt";
			break;
			
		
		//한명 멤버 불러오기
		case "/admin/getOne.do":
		
			
			model= service.getOneMember(keyMap);
			
			
			str="memberUpdate";
			break;
			
		case "/admin/update.do":
			model= service.memberUpdate(keyMap);
			
			str="/admin/getAllMember.do";
			break;
			
		case "/admin/searchMember.do":
			model= service.memberSearch(keyMap);
			
			str="memberSearchList";
			break;
			
		case "/admin/deleteMember.do":
			
			StringBuilder checkId = new StringBuilder();
			for(String id : request.getParameterValues("checkId")) {
				checkId.append(id+",");
				
			}
			keyMap.put("checkId", checkId.toString());

			model= service.memberDelete(keyMap);
			
			
			str ="/admin/getAllMember.do";
			break;		
			
			

		default:

			System.out.println("mismatch");
			break;

		}

		MyView view = viewResolver(str);

		
		view.render(model, request, response);

	}

	private MyView viewResolver(String viewName) {
		 if((viewName.substring(viewName.length()-2,viewName.length()).equals("do"))){
			 return new MyView(viewName);
		 }else {
			return new MyView("/view/admin/" + viewName + ".jsp");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new ConcurrentHashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

		return paramMap;
	}
	
	

	
	
	
	

}

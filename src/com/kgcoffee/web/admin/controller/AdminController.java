package com.kgcoffee.web.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgcoffee.web.admin.service.AdminService;
import com.kgcoffee.web.order.MyView;
import com.kgcoffee.web.users.vo.UsersVO;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
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
		String str = "/";
		Map<String, String> keyMap = createParamMap(request);

		Map<String, Object> model = null;
		MyView view=null;
		HttpSession session = request.getSession();
		UsersVO loginUser = ((UsersVO) session.getAttribute("loginUser"));
		String userId = "";

		String c = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(c);

		if (loginUser != null) {
			userId = loginUser.getUser_id();

			if (userId == "admin") {

				AdminService service = new AdminService();
				
				switch (c) {

				case "/admin/reportOrderByMenu.do":

					model = service.reportOrderByMenu(keyMap);
					
					str = "reportOrderByMenu";

					break;
					
				case "/admin/reportOrderByAgeGroup.do":

					model = service.reportOrderByAgeGroup(keyMap);
					
					str = "reportOrderByAgeGroup";

					break;
					
				case "/admin/reportOrderByMap.do":

					model= service.reportOrderByMap(keyMap);
					
					
					
					str = "reportOrderByMap";

					break;
					

				default:

					System.out.println("mismatch");
					break;

				}
				
				view = viewResolver(str);
				
			}else {
				
				view = new MyView(str);
				request.setAttribute("msg", "no-admin");
				
			}
			

		} else {

			

			view = new MyView(str);
			request.setAttribute("msg", "no-login");

		}

		

		view.render(model, request, response);

	}

	private MyView viewResolver(String viewName) {
		return new MyView("/view/admin/" + viewName + ".jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

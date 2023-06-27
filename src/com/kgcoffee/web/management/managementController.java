package com.kgcoffee.web.management;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.common.ControllerImpl;
import com.kgcoffee.web.order.MyView;

@WebServlet("/management/*")
public class managementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public managementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c = request.getRequestURI().substring(request.getContextPath().length());
		String str = "/management/";
		
		ControllerImpl impl = null; // 인터페이스
		
		switch(c) {
		case "/management/getAll.do":
			impl = new getAllMember();
			try {
				impl.execute(request,response);
			}catch(Exception e){
				e.printStackTrace();
			}
			str = "MemberList";
			
		} // switch-end
		
			MyView view = viewResolver(str);
	       
			Map<String, Object> model = new ConcurrentHashMap<>();
			view.render(model, request, response);
		
		
		
	}//doGet()-end
	
	 	private MyView viewResolver(String viewName) {
			
		 if (viewName.substring(6).equals(".do")) {
			 return new MyView("/management/" + viewName);
		 } else {
			 return new MyView("/view/management/" + viewName + ".jsp");
		 }
		 
		    
	 }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

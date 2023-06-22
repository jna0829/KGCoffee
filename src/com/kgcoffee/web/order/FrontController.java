package com.kgcoffee.web.order;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgcoffee.web.order.controller.cart.CartDeleteController;
import com.kgcoffee.web.order.controller.cart.CartInsertController;
import com.kgcoffee.web.order.controller.cart.CartListController;
import com.kgcoffee.web.order.controller.cart.CartUpdateController;
import com.kgcoffee.web.order.controller.order.OrderCompleteController;
import com.kgcoffee.web.order.controller.order.OrderController;
import com.kgcoffee.web.users.vo.UsersVO;


@WebServlet(name = "frontController", urlPatterns = "/order/*")
public class FrontController extends HttpServlet {
    private Map<String, Controller> controllerMap = new ConcurrentHashMap<>();
    String viewName ="";
    Map<String, Object> model=null;
    public FrontController() {
    	
        controllerMap.put("/kgCoffee/order/order", new
                OrderController());
        controllerMap.put("/kgCoffee/order/complete", new
                OrderCompleteController());
        controllerMap.put("/kgCoffee/order/cart", new
                CartListController());
        controllerMap.put("/kgCoffee/order/cart/insert", new
                CartInsertController());
        controllerMap.put("/kgCoffee/order/cart/delete", new
                CartDeleteController());
        controllerMap.put("/kgCoffee/order/cart/update", new
                CartUpdateController());
        
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	
        String requestURI = request.getRequestURI();
        
        System.out.println(requestURI);
        Controller controller = controllerMap.get(requestURI);
        // 해당 controller 없을 경우 404 page 반환
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // 파라미터가 있을 경우 Map 구조에 담음
        Map<String, Object> paramMap = createParamMap(request);
        if(paramMap.containsKey("loginUser")) {
        // Model 객체 생성
        model = new ConcurrentHashMap<>();
        viewName = controller.process(paramMap, model);
        }else {
        	
        	viewName= "beforeLogin";
        	
        }
        
        // view 반환
        MyView view = viewResolver(viewName);
        // 렌더링
        view.render(model, request, response);
        
  
        
        
    }

    private Map<String, Object> createParamMap(HttpServletRequest request) {
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        
        request.getAttributeNames().asIterator()
        		.forEachRemaining(attrName -> paramMap.put(attrName,
        				(String)request.getAttribute(attrName)));
        HttpSession session = request.getSession();
        UsersVO loginUser=((UsersVO)session.getAttribute("loginUser"));
        
        paramMap.put("loginUser",loginUser);
        
        
        
        
        return paramMap;
    }

    private MyView viewResolver(String viewName) {
        
   
    	return new MyView("/view/order/" + viewName + ".jsp");
        
        
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	
    	service(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	service(req, resp);
    }
}
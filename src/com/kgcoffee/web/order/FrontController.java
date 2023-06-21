package com.kgcoffee.web.order;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.order.controller.basket.BasketDeleteController;
import com.kgcoffee.web.order.controller.basket.BasketListController;
import com.kgcoffee.web.order.controller.basket.BasketUpdateController;
import com.kgcoffee.web.order.controller.order.OrderCompleteController;
import com.kgcoffee.web.order.controller.order.OrderController;


@WebServlet(name = "frontController", urlPatterns = "/order/*")
public class FrontController extends HttpServlet {
    private Map<String, Controller> controllerMap = new ConcurrentHashMap<>();

    public FrontController() {
    	
        controllerMap.put("/kgCoffee/order/order", new
                OrderController());
        controllerMap.put("/kgCoffee/order/complete", new
                OrderCompleteController());
        controllerMap.put("/kgCoffee/order/basket", new
                BasketListController());
        controllerMap.put("/kgCoffee/order/basket/delete", new
                BasketDeleteController());
        controllerMap.put("/kgCoffee/order/basket/update", new
                BasketUpdateController());
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
        Map<String, String> paramMap = createParamMap(request);
        // Model 객체 생성
        Map<String, Object> model = new ConcurrentHashMap<>();
        String viewName = controller.process(paramMap, model);
        // view 반환
        MyView view = viewResolver(viewName);
        // 렌더링
        view.render(model, request, response);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new ConcurrentHashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
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
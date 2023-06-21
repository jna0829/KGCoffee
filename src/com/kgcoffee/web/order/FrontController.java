package hello.servlet.web.frontcontroller.kgcoffee;


import hello.servlet.web.frontcontroller.kgcoffee.controller.basket.BasketDeleteController;
import hello.servlet.web.frontcontroller.kgcoffee.controller.basket.BasketUpdateController;
import hello.servlet.web.frontcontroller.kgcoffee.controller.order.OrderCompleteController;
import hello.servlet.web.frontcontroller.kgcoffee.controller.order.OrderController;
import hello.servlet.web.frontcontroller.kgcoffee.controller.basket.BasketListController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@WebServlet(name = "frontController", urlPatterns = "/api/*")
public class FrontController extends HttpServlet {
    private Map<String, Controller> controllerMap = new ConcurrentHashMap<>();

    public FrontController() {
        controllerMap.put("/api/order", new
                OrderController());
        controllerMap.put("/api/order/complete", new
                OrderCompleteController());
        controllerMap.put("/api/basket", new
                BasketListController());
        controllerMap.put("/api/basket/delete", new
                BasketDeleteController());
        controllerMap.put("/api/basket/update", new
                BasketUpdateController());
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
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
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
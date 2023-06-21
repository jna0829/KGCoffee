package hello.servlet.web.frontcontroller.kgcoffee;

import java.util.Map;

public interface Controller {
    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}

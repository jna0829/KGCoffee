package hello.servlet.web.frontcontroller.kgcoffee.controller.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import hello.servlet.web.frontcontroller.kgcoffee.Controller;

import java.io.IOException;
import java.util.Map;


public class OrderCompleteController implements Controller {

    private ObjectMapper objectMapper;


    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        // DB TABLE 생성해서 주문 정보 원하는 값들만 넣어주면 됨.





        return "result-form";
    }
}

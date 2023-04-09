package com.example.springlogger.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoggingServiceImpl implements LoggingService{

    @Override
    public void displayReq(HttpServletRequest request, Object body) {
        //TODO write logging body
    }

    @Override
    public void displayResp(HttpServletRequest request, HttpServletResponse response, Object body) {
        //TODO write logging body
    }

    private Map<String,String> getParameters(HttpServletRequest request) {

        Map<String,String> parameters = new HashMap<>();
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()) {
            String paramName = params.nextElement();
            parameters.put( paramName , request.getParameter( paramName ));
        }
        return parameters;
    }
}

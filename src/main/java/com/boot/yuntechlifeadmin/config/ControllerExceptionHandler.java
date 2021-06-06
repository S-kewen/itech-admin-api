package com.boot.yuntechlifeadmin.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.boot.yuntechlifeadmin.entity.system.SystemLog;
import com.boot.yuntechlifeadmin.service.system.SystemLogService;
import com.boot.yuntechlifeadmin.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @Autowired
    private Util util;
    @Value("${performance.serviceId.admin}")
    private int adminServiceId;
    @Autowired
    private SystemLogService systemLogService;
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest request, Exception e) {
        JSONObject json = new JSONObject();
        SystemLog systemLog = new SystemLog();
        String hostname = "unknown";
        String ip = "unknown";
        json.put("tip", e.getMessage());
        json.put("timestamp", System.currentTimeMillis());
        json.put("ip", util.getLocalIp(request));
        json.put("query", request.getQueryString());
        json.put("method", request.getMethod());
        json.put("contextPath", request.getContextPath());
        json.put("cookies", request.getCookies());
        json.put("header", request.getHeader("user-agent"));
        json.put("authType", request.getAuthType());
        json.put("query", request.getQueryString());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            systemLog.setType(2);
            json.put("status", -404);
        } else {
            systemLog.setType(3);
            json.put("status", -500);
        }
        try {
            hostname = InetAddress.getLocalHost().getHostName();
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (java.net.UnknownHostException ex) {
            json.put("exception",ex.toString());
        }
        systemLog.setState(2);
        systemLog.setService_id(adminServiceId);
        systemLog.setPc_name(hostname);
        systemLog.setIp(ip);
        systemLog.setMsg(json.toString());
        systemLog.setRemark("ControllerExceptionHandler");
        if (systemLogService.insertOne(systemLog)==0){
            System.out.println("ControllerExceptionHandler fail!!!");
        }
        return json;
    }
}
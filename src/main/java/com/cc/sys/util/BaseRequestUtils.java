package com.cc.sys.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 添加获取 request对象的基础类
 */
@Component
public class BaseRequestUtils {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    public HttpServletRequest getRequest(){
        return request;
    }

    public HttpSession getSession(){
        return session;
    }
}

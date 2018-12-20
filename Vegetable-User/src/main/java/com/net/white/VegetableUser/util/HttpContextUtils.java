package com.net.white.VegetableUser.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HttpContextUtils
 * @Description TODO
 * @Author wangxijun
 * @Date 2018/12/20 11:29
 * @Version 1.0
 **/
public class HttpContextUtils{

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
}

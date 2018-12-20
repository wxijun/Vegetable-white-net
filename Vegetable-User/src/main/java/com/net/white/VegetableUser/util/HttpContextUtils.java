package com.net.white.VegetableUser.util;

import org.springframework.web.context.request.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HttpContextUtils spring获取request
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

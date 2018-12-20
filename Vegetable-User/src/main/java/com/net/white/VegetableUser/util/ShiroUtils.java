package com.net.white.VegetableUser.util;

import org.apache.shiro.SecurityUtils;

/**
 * @ClassName ShiroUtils  获取登录用户信息，未完成
 * @Description TODO
 * @Author wangxijun
 * @Date 2018/12/20 11:29
 * @Version 1.0
 **/
public class ShiroUtils {

    public static void getUserEntity(){

        SecurityUtils.getSubject().getPrincipal();

    }
}

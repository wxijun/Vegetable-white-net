package com.net.white.VegetableUser.util;

import com.net.white.VegetableUser.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

/**
 * @ClassName ShiroUtils
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

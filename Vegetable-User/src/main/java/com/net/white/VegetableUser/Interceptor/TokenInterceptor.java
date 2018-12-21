package com.net.white.VegetableUser.Interceptor;

import com.net.white.VegetableUser.entity.Token;
import com.net.white.VegetableUser.repository.TokenRepository;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.*;

import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.Date;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenRepository tokenRepository;
    //提供查询
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {}
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {}
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        //普通路径放行
        if ("/user/yanzheng".equals(arg0.getRequestURI()) || "/user/login".equals(arg0.getRequestURI())) {
            return true;}

        //权限路径拦截
        arg1.setCharacterEncoding("UTF-8");
        PrintWriter resultWriter=arg1.getWriter();
        final String headerToken=arg0.getHeader("XW-Token");
        //判断请求信息
        if(null==headerToken||headerToken.trim().equals("")){
            resultWriter.write("你没有token,需要登录");
            return false;
        }
        //解析Token信息
        try {
            Claims claims = Jwts.parser().setSigningKey("junjun").parseClaimsJws(headerToken).getBody();
            String tokenUserId=(String)claims.get("userid");
            //根据客户Token查找数据库Token
            Token myToken=tokenRepository.findByUserId(tokenUserId);

            //数据库没有Token记录
            if(null==myToken) {
                resultWriter.write("我没有你的token？,需要登录");
                return false;
            }
            //数据库Token与客户Token比较
            if( !headerToken.equals(myToken.getToken()) ){
                resultWriter.write("你的token修改过？,需要登录");
                return false;
            }
            //判断Token过期
            Date tokenDate=(Date)claims.getExpiration();
            int chaoshi=(int)(new Date().getTime()-tokenDate.getTime())/1000;
            if(chaoshi>60*60*24*3){
                resultWriter.write("你的token过期了？,需要登录");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultWriter.write("反正token不对,需要登录");
            return false;
        }
        //最后才放行
        return true;
    }

}

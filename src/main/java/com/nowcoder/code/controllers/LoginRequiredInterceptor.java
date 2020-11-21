package com.nowcoder.code.controllers;

import com.nowcoder.code.service.LoginService;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
public class LoginRequiredInterceptor extends ControllerInterceptorAdapter {
    @Autowired
    LoginService loginService;

    public LoginRequiredInterceptor(){
        setPriority(100);
    }

    @Override
    protected Class<? extends Annotation> getRequiredAnnotationClass() {
        return LoginRequired.class;
    }

    @Override
    protected Object before(Invocation inv) throws Exception {
        System.out.println("request: " + inv.getRequest());
        Cookie cookieUserId = WebUtils.getCookie(inv.getRequest(), "userId");
        Integer userId = cookieUserId == null? null : Integer.parseInt(cookieUserId.getValue());
        Cookie cookieLoginToken = WebUtils.getCookie(inv.getRequest(), "loginToken");
        String loginToken = cookieLoginToken == null? null : cookieLoginToken.getValue();
        System.out.println("userId = " + userId + ", loginToken = " + loginToken);
        if(userId == null || loginToken == null || !loginService.checkLoginToken(userId, loginToken)){
            return "r:" + inv.getRequest().getContextPath() + "/login";
        }
        return true;
    }
}

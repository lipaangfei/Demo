package com.nowcoder.code.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/28
 */
@Path("")
public class HomeController {
    @LoginRequired
    @Get("main")
    public String main(Invocation inv){
        Cookie cookie = WebUtils.getCookie(inv.getRequest(), "email");
        System.out.println("path = /main, request: " + inv.getRequest());
        String email = cookie == null? "" : cookie.getValue();
        inv.addModel("email", email);//注意, 否则/main不显示账号信息
        /*
        Cookie cookieLoginToken = WebUtils.getCookie(inv.getRequest(), "loginToken");
        String loginToken = cookieLoginToken == null? null : cookieLoginToken.getValue();
        inv.addModel("loginToken", loginToken);//注意, 否则/main不显示账号信息
         */
        return "main";
    }
    @Get({"", "index", "/", "home"})
    public String entry(){
        return "home";
    }
}

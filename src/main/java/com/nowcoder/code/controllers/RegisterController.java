package com.nowcoder.code.controllers;

import com.nowcoder.code.constant.LoginResult;
import com.nowcoder.code.constant.RegisterResult;
import com.nowcoder.code.model.UserInfo;
import com.nowcoder.code.service.RegisterService;
import com.nowcoder.code.service.UserService;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
@Path("")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @Autowired
    UserService userService;

    @Get("/register")
    public String registerRequest(){
        return "register/register";
    }

    @Post("/register")
    public String register(Invocation inv, UserInfo userInfo, @Param("repeatedPassword") String repeatedPassword, @Param("verifyCode") String verifyCode){
        Cookie cookie = WebUtils.getCookie(inv.getRequest(), "verifyCodeId");
        String verifyCodeId = cookie == null? null : cookie.getValue();
        System.out.println("User register: " + ToStringBuilder.reflectionToString(userInfo));
        System.out.println("Verify Code: " + verifyCode);
        System.out.println("Verify Code Id: " + verifyCodeId);
        System.out.println("Repeated Password" + repeatedPassword);
        RegisterResult registerResult = registerService.checkRegister(userInfo, repeatedPassword, verifyCode, verifyCodeId);
        switch (registerResult){
            case FORM_EMPTY:
                inv.addModel("errorMessage", "注册信息不能为空");
                filloutForm(inv, userInfo, repeatedPassword, verifyCode);
                return "register/register";
            case REPEATED_PASSWORD_UNMATCH:
                inv.addModel("errorMessage", "两个密码不匹配");
                filloutForm(inv, userInfo, repeatedPassword, verifyCode);
                return "register/register";
            case VERIFY_CODE_ERROR:
                inv.addModel("errorMessage", "验证码错误");
                filloutForm(inv, userInfo, repeatedPassword, verifyCode);
                return "register/register";
            case EMAIL_EXIST:
                inv.addModel("errorMessage", "该邮箱账号已存在");
                filloutForm(inv, userInfo, repeatedPassword, verifyCode);
                return "register/register";
            case SUCCESS:
                userService.addUser(userInfo);
                //filloutForm(inv, userInfo, repeatedPassword, verifyCode);
                return "register/register_redir";
            default:
                return "@undefined error";
        }
    }
    private void filloutForm(Invocation inv, UserInfo userInfo, String repeatedPassword, String verifyCode){
        inv.addModel("email", userInfo.getEmail());
        inv.addModel("nickname", userInfo.getNickname());
        inv.addModel("phone", userInfo.getPhone());
        inv.addModel("password", userInfo.getPassword());
        inv.addModel("repeatedPassword", repeatedPassword);
    }
}

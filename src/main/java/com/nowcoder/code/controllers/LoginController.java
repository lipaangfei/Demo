package com.nowcoder.code.controllers;

import com.nowcoder.code.constant.LoginResult;
import com.nowcoder.code.dao.UserDAO;
import com.nowcoder.code.model.UserInfo;
import com.nowcoder.code.service.LoginService;
import com.nowcoder.code.service.UserService;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.nowcoder.code.commons.util.NowcoderWebUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import java.util.Random;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
@Path("")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    public static String createToken(int id){
        String salt = "handsome";
        String md5_1 = NowcoderWebUtils.getMD5(Integer.toString(id) +
                System.currentTimeMillis() + new Random().nextInt());
        String md5_2 = NowcoderWebUtils.getMD5(md5_1 + salt);
        return md5_2;
    }
    @Get("/login")
    public String loginRequest(Invocation inv){
        Cookie cookie = new Cookie("verifyCodeId", "1994");
        inv.getResponse().addCookie(cookie);
        return "login/login";
    }

    @Post("/login")
    public String login(Invocation inv, UserInfo userInfo, @Param("verifyCode") String verifyCode){
        System.out.println("User login: " + ToStringBuilder.reflectionToString(userInfo));
        System.out.println("Verify Code: " + verifyCode);
        Cookie cookie = WebUtils.getCookie(inv.getRequest(), "verifyCodeId");
        String verifyCodeId = cookie == null? null : cookie.getValue();
        LoginResult loginResult = loginService.checkLogin(userInfo.getEmail(), userInfo.getPassword(), verifyCode, verifyCodeId);
        switch (loginResult){
            case FORM_EMPTY:
                inv.addModel("errorMessage", "登录信息不能为空");
                filloutForm(inv, userInfo);
                return "login/login";
            case VERIFY_CODE_ERROR:
                inv.addModel("errorMessage", "验证码错误");
                filloutForm(inv, userInfo);
                return "login/login";
            case USERNAME_PASSWORD_ERROR:
                inv.addModel("errorMessage", "用户名或密码错误");
                filloutForm(inv, userInfo);
                return "login/login";
            case SUCCESS:
                int id = userService.getUserInfoByEmail(userInfo.getEmail()).getId();
                String token = createToken(id);
                loginService.updateLoginTokenById(id, token);//根据loginToken判断用户是否登录
                System.out.println("token " + token);
                inv.addModel("email", userInfo.getEmail());
                inv.getResponse().addCookie(new Cookie("userId", Integer.toString(id)));
                inv.getResponse().addCookie(new Cookie("loginToken", token));
                inv.getResponse().addCookie(new Cookie("email", userInfo.getEmail()));
                System.out.println("path = /login, request: " + inv.getRequest() );
                System.out.println("path = /login, response: " + inv.getResponse() );
                return "login/login_redir";
            default:
                return "@undefined error";
        }
    }

    @Get("/logout")
    public String logoutRequest(Invocation inv){
        //根据loginToken判断当前登录用户，因此登出后为空
        inv.getResponse().addCookie(new Cookie("loginToken", ""));
        return "login/logout_redir";
    }

    private void filloutForm(Invocation inv, UserInfo userInfo){
        inv.addModel("email", userInfo.getEmail());
        inv.addModel("password", userInfo.getPassword());
    }
}

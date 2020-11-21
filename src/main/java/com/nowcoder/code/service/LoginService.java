package com.nowcoder.code.service;

import com.nowcoder.code.constant.LoginResult;
import com.nowcoder.code.dao.UserDAO;
import com.nowcoder.code.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.apache.commons.lang.StringUtils.isEmpty;
import static org.apache.commons.lang.StringUtils.trim;

import java.util.List;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */

@Service
public class LoginService {
    @Autowired
    private UserDAO userDAO;

    /**
     * verifyCodeId保存到redis中自动过期，对应不同的verifyCode
     *
     */
    private boolean checkVerifyCode(String verifyCodeId, String verifyCode) {
        //todo
        return true;
    }

    private boolean checkEmailAndPassword(String email, String password){
        UserInfo userInfo = userDAO.getUserInfoByEmail(email);
        if(userInfo == null){
            return false;
        }
        System.out.println(email + " logged in with password = " + password);
        System.out.println(userInfo.toString());

        return password.equals(userInfo.getPassword());
    }

    public LoginResult checkLogin(String email, String password, String verifyCode, String verifyCodeId){
        email = trim(email);
        password = trim(password);
        verifyCode = trim(verifyCode);
        verifyCodeId = trim(verifyCodeId);
        if(isEmpty(email) || isEmpty(password) || isEmpty(verifyCode) || isEmpty(verifyCodeId)){
            return LoginResult.FORM_EMPTY;
        }

        if(!checkVerifyCode(verifyCodeId, verifyCode)){
            return LoginResult.VERIFY_CODE_ERROR;
        }
        if(!checkEmailAndPassword(email, password)){
            return LoginResult.USERNAME_PASSWORD_ERROR;
        }
        return LoginResult.SUCCESS;
    }

    public boolean checkLoginToken(int id, String oldLoginToken){
        String loginToken = userDAO.getLoginTokerById(id);
        System.out.println(loginToken);
        //可能会伪造ID，token不存在的情况
        return loginToken != null && oldLoginToken.equals(loginToken);
    }

    public void updateLoginTokenById(int id, String loginToken){
        userDAO.updateLoginTokenById(id, loginToken);
    }
}

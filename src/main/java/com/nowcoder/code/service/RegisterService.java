package com.nowcoder.code.service;

import com.nowcoder.code.constant.LoginResult;
import com.nowcoder.code.constant.RegisterResult;
import com.nowcoder.code.dao.UserDAO;
import com.nowcoder.code.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang.StringUtils.isEmpty;
import static org.apache.commons.lang.StringUtils.trim;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
@Service
public class RegisterService {
    @Autowired
    private UserDAO userDAO;
    /**
     * verifyCodeId保存到redis中自动过期，对应不同的verifyCode
     */
    private boolean checkVerifyCode(String verifyCodeId, String verifyCode) {
        //todo
        return true;
    }

    public RegisterResult checkRegister(UserInfo userInfo, String repeatedPassword, String verifyCode, String verifyCodeId){
        repeatedPassword = trim(repeatedPassword);
        verifyCode = trim(verifyCode);
        verifyCodeId = trim(verifyCodeId);
        if(isEmpty(userInfo.getEmail()) || isEmpty(userInfo.getNickname()) || isEmpty(userInfo.getPhone()) || isEmpty(userInfo.getPassword())
            || isEmpty(repeatedPassword) || isEmpty(verifyCode) || isEmpty(verifyCodeId)){
            return RegisterResult.FORM_EMPTY;
        }
        if(!userInfo.getPassword().equals(repeatedPassword)){
            return RegisterResult.REPEATED_PASSWORD_UNMATCH;
        }
        if(!checkVerifyCode(verifyCodeId, verifyCode)){
            return RegisterResult.VERIFY_CODE_ERROR;
        }
        if(userDAO.getUserInfoByEmail(userInfo.getEmail()) != null){
            return RegisterResult.EMAIL_EXIST;
        }
        return RegisterResult.SUCCESS;
    }
}

package com.nowcoder.code.constant;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
public enum LoginResult {
    FORM_EMPTY("FORM_EMPTY"),
    VERIFY_CODE_ERROR("VERIFY_CODE_ERROR"),
    USERNAME_PASSWORD_ERROR("USERNAME_PASSWORD_ERROR"),
    SUCCESS("SUCCESS");
    private String type;
    LoginResult(){}
    LoginResult(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

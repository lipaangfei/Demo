package com.nowcoder.code.constant;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
public enum RegisterResult {
    FORM_EMPTY("FORM_EMPTY"),
    VERIFY_CODE_ERROR("VERIFY_CODE_ERROR"),
    REPEATED_PASSWORD_UNMATCH("REPEATED_PASSWORD_UNMATCH"),
    EMAIL_EXIST("EMAIL_EXIST"),
    SUCCESS("SUCCESS");
    private String type;
    RegisterResult(){}
    RegisterResult(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

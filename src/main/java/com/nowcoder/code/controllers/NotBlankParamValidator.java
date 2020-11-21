package com.nowcoder.code.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;

/**
 * @author Pengfei Li
 * @date 2020/11/9
 */
public class NotBlankParamValidator implements ParamValidator {
    @Override
    public Object validate(ParamMetaData paramMetaData, Invocation invocation, Object o, Errors errors) {
        String paramName = paramMetaData.getParamName();
        String value = invocation.getParameter(paramName);
        if(StringUtils.isBlank(value)){
            return "@参数不能为空";
        }
        return null;
    }

    @Override
    public boolean supports(ParamMetaData paramMetaData) {
        return paramMetaData.getAnnotation(NotBlank.class) != null;
    }
}

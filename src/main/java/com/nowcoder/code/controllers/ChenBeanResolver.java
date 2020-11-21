package com.nowcoder.code.controllers;

import com.nowcoder.code.model.Chen;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;

/**
 * @author Pengfei Li
 * @date 2020/11/9
 */
public class ChenBeanResolver implements ParamResolver {

    @Override
    public Object resolve(Invocation invocation, ParamMetaData paramMetaData) throws Exception {
        for (String paramName : paramMetaData.getParamNames()){
            if(paramName != null){
                String chen1 = invocation.getParameter("chen1");
                String chen2 = invocation.getParameter("chen2");
                Chen chen = new Chen();
                chen.setChen1(chen1);
                chen.setChen2(chen2);
                return chen;
            }
        }
        return null;
    }

    @Override
    public boolean supports(ParamMetaData paramMetaData) {
        return Chen.class == paramMetaData.getParamType();
    }
}

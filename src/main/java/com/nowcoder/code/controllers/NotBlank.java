package com.nowcoder.code.controllers;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Pengfei Li
 * @date 2020/11/9
 */
//@Target({ElementType.TYPE, ElementType.METHOD})
@Target({ElementType.PARAMETER}) //注意是参数
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotBlank {

}

package com.nowcoder.code.controllers;

import java.lang.annotation.*;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired { //Note @interface, 定义一个注解LoginRequired

}

package com.bkw.module.arouter_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ARouter {
    /**
     * 路径名，如：/app/MainActivity
     */
    String path();

    /**
     * 组名，默认可以不写
     */
    String group() default "";
}

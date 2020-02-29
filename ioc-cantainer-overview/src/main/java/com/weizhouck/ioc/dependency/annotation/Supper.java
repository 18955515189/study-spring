package com.weizhouck.ioc.dependency.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @author 飞翔的胖哥
 * @version 1.0.0
 * @description TODO
 * @since 2020/2/29 0029 15:44
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface Supper {
}

package com.tlstarter.first;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *
 * how use
 *
 * @EnableTL
 * @Configuration
 * public class YouClass {
 *
 * }
 * Created by tianlei on 2020/1/17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({TLConfiguration.class})
public @interface EnableTL {

}

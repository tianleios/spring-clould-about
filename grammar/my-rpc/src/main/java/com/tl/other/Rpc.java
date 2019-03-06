package com.tl.other;

import java.lang.annotation.*;

/**
 * Created by tianlei on 2019/2/27
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Rpc {
}

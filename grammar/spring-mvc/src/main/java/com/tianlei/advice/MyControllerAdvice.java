package com.tianlei.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tianlei on 2018/9/29
 */
@ControllerAdvice
public class MyControllerAdvice {

    //有多个处理同一异常的话，只有第一个有效
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.GATEWAY_TIMEOUT)
    @ResponseBody
    public String myHandler(RuntimeException e) {
        return "myHandler";
    }

}

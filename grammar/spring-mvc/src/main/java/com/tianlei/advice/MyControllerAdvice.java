package com.tianlei.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

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

    @InitBinder
    public void bind(WebDataBinder webDataBinder) {

        CustomDateEditor customDateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
        webDataBinder.registerCustomEditor(Long.class, customDateEditor);
    }

}

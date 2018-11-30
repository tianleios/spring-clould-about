package com.tianlei.controller;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianlei on 2018/9/28
 */
@ControllerAdvice
public class Advice {


    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public Map handler(Exception e) throws Exception {

        StringBuilder sb = new StringBuilder();
        if (e instanceof BindException) {
            BindException te = (BindException) e;
            te.getFieldErrors().forEach(eror -> {
                appendStr(sb, eror);
            });
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException te = (MethodArgumentNotValidException) e;
            te.getBindingResult().getAllErrors().forEach(eror -> {
                appendStr(sb, eror);
            });
        }

        String desp = sb.toString();
        if (desp.endsWith(", ")) {
            desp = desp.substring(0, desp.length() - 2);
        }
        Map map = new HashMap();
        map.put("errorCode", 99);
        map.put("errorDesp", desp);
        return map;
    }

    private void appendStr(StringBuilder sb, ObjectError error) {
        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            sb.append(fieldError.getField()).append(" ").append(fieldError.getDefaultMessage()).append(", ");
        } else {
            sb.append(error.getDefaultMessage()).append(", ");
        }

    }


}

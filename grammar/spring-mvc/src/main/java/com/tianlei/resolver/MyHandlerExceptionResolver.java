package com.tianlei.resolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tianlei on 2018/9/30
 */
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    // 没有实现 order 接口， 排序靠后
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return null;
    }

}

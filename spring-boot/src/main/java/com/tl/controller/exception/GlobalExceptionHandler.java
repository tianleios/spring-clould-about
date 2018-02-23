package com.tl.controller.exception;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

// 全局的异常处理
@RestControllerAdvice
public class GlobalExceptionHandler {

    //http://blog.csdn.net/viviju1989/article/details/8529453 获取方法名称
    @ExceptionHandler(value = {Exception.class})
    public String handlerError(HttpServletRequest request, Exception e) {

        if (e instanceof ConstraintViolationException) {

            // 获取方法名称
//            LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
//            try {
//
//                UserController.class.getMethod("test");
//                String[] paramName = nameDiscoverer.getParameterNames();
//
//            } catch (Exception e) {
//
//            }


            //
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;

            Set set = constraintViolationException.getConstraintViolations();
            // default is ""
            StringBuilder stringBuilder = new StringBuilder("");
            //
            if (set.size() <= 0) {
                return "yi chang";
            }

            // 有异常信息
            Iterator<ConstraintViolation> iterator = set.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation constraintViolation = iterator.next();

                // 获取属性名称
                PathImpl path = (PathImpl) constraintViolation.getPropertyPath();
                String propertyName = path.getLeafNode().getName();
                if (propertyName != null) {

                    stringBuilder.append("[" + propertyName + "]");
                    // stringBuilder.append(":");

                }

                // 获取异常信息
                // 注释的信息
                String msg = constraintViolation.getMessage();
                if (msg != null) {
                    stringBuilder.append(msg);
                    // stringBuilder.append("-");
                    stringBuilder.append(";");
                }

            }

            return stringBuilder.toString();

        }

        return "error";

    }


}

package com.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {

    //定义一个切点，用来筛选连接点， 连接点只是一个程序的边界，比如 方法开始前、开始后，
    @Pointcut(value = "execution(public * com.aop.controller.AopController.*(..))")
    public void pointCut() {


    }


    // 前置增强
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {

        System.out.println("方法执行前");

    }

    // 后置增强
    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint) {

        System.out.println("方法执行后");

    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void afterReturning(Object ret) {

        System.out.println("方法返回后");

    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void afterThrowing(Throwable e) {

        System.out.println("方法出现异常");

    }


    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint pjp) {

        try {

            Object obj = pjp.proceed();
            return obj;

        } catch (Throwable e) {

            return null;

        }

    }


}

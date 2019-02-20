package com.aop;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Created by tianlei on 2018/12/12
 */
public class AopTest {


    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(User.class);
        enhancer.setCallbacks(new Callback[] {new  UserMethodInterceptor(), new UserSleepMethodInterceptor()} );
        enhancer.setCallbackFilter(new UserCallbackFilter());
        User user = (User) enhancer.create();
        user.sayHi();
        user.sleep();

    }


    public static class User {
        public void sayHi() {
            System.out.println("say hi!");
        }

        public void sleep() {
            System.out.println("I am sleeping");
        }
    }

    // 当做代理使用
    public static class UserMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("张嘴");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("闭嘴");
            return result;
        }
    }


    public static class UserSleepMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("刷牙");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("起床");
            return result;
        }
    }

    public static class UserCallbackFilter implements CallbackFilter {
        // 返回值为指定callbackFilter 中哪个 methodInterceptor
        @Override
        public int accept(Method method) {
            if ("sleep".equals(method.getName())) {
                return 1;
            }
            return 0;
        }
    }

}

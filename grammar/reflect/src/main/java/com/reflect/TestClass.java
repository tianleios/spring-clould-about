package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestClass {


    /////////公有
    public String publicName;


    //////////////  私有
    private String privateFriendName;

    public String getPrivateFriendName() {
        return privateFriendName;
    }

    public void setPrivateFriendName(String privateFriendName) {
        this.privateFriendName = privateFriendName;
    }


    public String testMethod(String args0) {

        return "test";
    }

    public static void main(final String[] args) {

        try {

            //1. 通过反射分析类
            String classPath = "com.reflect.TestClass";
            Class thisClass = Class.forName(classPath);
            TestClass testClass = (TestClass) thisClass.newInstance();

            //方法
            Method[] allMethod = thisClass.getMethods();
            for (Method method : allMethod) {

                String methodName = method.getName();
                Class returnType = method.getReturnType();
                Class[] paramterTypes = method.getParameterTypes();
                int a = 10;

            }

            //属性
            Field[] fields = thisClass.getFields();
            for (Field field : fields) {

               String name = field.getName();

               //获取某个 对象 的 域
               Object obj = field.get(testClass);
               //设置值
               field.set(testClass,"new value");
            }



                int a = 10;


        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}

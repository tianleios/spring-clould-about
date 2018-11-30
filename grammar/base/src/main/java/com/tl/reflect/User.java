package com.tl.reflect;

import java.lang.reflect.Field;

/**
 * Created by tianlei on 2018/10/8
 */
public class User {

    private Integer age;
    public String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception {


        User user = new User();
        Field ageField = user.getClass().getDeclaredField("age");
        ageField.set(user,10);
        int a = 10;



    }

    public static int f(int n) {

        if (n < 3) {
            return 1;
        }
        int i = 1;
        int j = 1;

        int a,b;

        for (int num = 3; num <= n; num ++) {

            a = i;
            b = j;

            i = b;
            j = a + b;

        }

        return j;



    }




}

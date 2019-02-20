package com.tl.algorithm;

/**
 * Created by tianlei on 2019/1/26
 */
public class Test {

    public Integer value;

    public static class User {

        static {
            System.out.println(Test.User.class.getSimpleName());
        }

        public User() {
            System.out.println("User construct");
        }
    }

    public static class Teacher extends User {

        static {
            System.out.println(Test.Teacher.class.getSimpleName());
        }

        public Teacher() {
            System.out.println("Teacher construct");
        }
    }

    public static void main(String[] args) {

        Test test = new Test();
        if (test.value == 1) {

        }

    }
}

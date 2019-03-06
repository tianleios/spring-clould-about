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

        System.out.println("begin ");
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    System.out.println("123124312");
                    Thread.sleep(1000);
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(12444);

    }


    @org.junit.Test
    public void testThreadSleep() throws InterruptedException {
        System.out.println("begin ");
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    System.out.println("123124312");
//                    Thread.sleep(1000);
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(12444);
    }
}

package com.tl.proxy;

/**
 * Created by tianlei on 2018/9/4
 */
public class ProxyTest {

    // 静态代理
    public static void main(String[] args) {
       Subject subject = new Proxy(new RealSubject());
       subject.visit();
    }

    //主题
    interface Subject {
        void visit();
    }

    //真实对象
    static class RealSubject implements Subject {
        @Override
        public void visit() {
            System.out.println("i am boss");
        }
    }

    // 代理
    static class Proxy implements Subject {
        Subject subject;
        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void visit() {
            subject.visit();
        }
    }



}

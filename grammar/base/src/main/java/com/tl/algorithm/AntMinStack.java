package com.tl.algorithm;

import java.util.Stack;

/**
 * Created by tianlei on 2019/1/5
 */
public class AntMinStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public AntMinStack() {
    }


    public Integer pop() {
       if (stack.peek() == minStack.peek()) {
           minStack.pop();
       }
       return stack.pop();
    }

    public void push(Integer obj) {
        assert null != obj;
        stack.push(obj);
        if (minStack.empty() || obj <= minStack.peek()) {
            minStack.push(obj);
        }
    }

    public Integer min() {
        if (stack.empty()) {
            return null;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {

        AntMinStack stack = new AntMinStack();
        for (int i = 10; i > 0; i--) {
            stack.push2(i);
            System.out.println("push-" + i + " min-" + stack.min());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("pop-" + "min: " + stack.min() + " value-" +stack.pop2() );
        }

    }


    public void push2(Integer obj) {

        stack.push(obj);
        if (minStack.empty() || obj <= minStack.peek()) {
            minStack.push(obj);
        }

    }

    public Integer pop2() {
        if (stack.empty()) {
            return null;
        }
        Integer value = stack.pop();
        if (value.equals(minStack.peek())) {
            minStack.pop();
        }
        return value;
    }





}

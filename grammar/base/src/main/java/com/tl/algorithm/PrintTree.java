package com.tl.algorithm;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by tianlei on 2019/1/6
 */
public class PrintTree {


    public static class Node {
        public Integer value;
        public Node right;
        public Node left;

    }

    public static void main(String[] args) {

        Node node1 = new Node();
        node1.value = 1;

        Node node1l = new Node();
        node1l.value = 11;

        Node node1r = new Node();
        node1r.value = 22;

        node1.left = node1l;
        node1.right = node1r;

        print(node1);

    }

    public static void print(Node node) {

        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(node);
        while (linkedList.peek() != null) {
            Node temp = linkedList.poll();
            System.out.println(temp.value);
            if (temp.right != null) {
                linkedList.add(temp.right);
            }
            if (temp.left != null) {
                linkedList.add(temp.left);
            }
        }

    }


    @Test
    public void rr() {

        Node node1 = new Node();
        node1.value = 1;

        Node node1l = new Node();
        node1l.value = 11;

        Node node1r = new Node();
        node1r.value = 22;

        node1.left = node1l;
        node1.right = node1r;


        reversal(node1);

        int a = 0;

    }

    public static void reversal(Node node) {

        if (null == node) {
            return;
        }

        reversal(node.left);
        reversal(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

    }


}

package com.tl.algorithm.linkedList;

/**
 * Created by tianlei on 2019/1/6
 */
public class PrintLinkedList {

    public static class Node {
        public Integer value;
        public Node next;
    }


    public static void main(String[] args) {

        Node n1 = new Node();
        n1.value = 1;

        Node n2 = new Node();
        n2.value = 2;

        Node n3 = new Node();
        n3.value = 3;

        Node n4 = new Node();
        n4.value = 4;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        print(n1);
    }

    public static void print(Node head) {


        if (head.next != null) {
            print(head.next);
        }

        System.out.println(head.value);


    }

    public static void print2(Node head) {

        if (head.next != null) {
            print2(head.next);
        }

        System.out.println(head.value);
    }




}

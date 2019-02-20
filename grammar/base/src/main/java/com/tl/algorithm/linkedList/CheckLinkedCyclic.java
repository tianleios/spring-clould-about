package com.tl.algorithm.linkedList;

/**
 * Created by tianlei on 2019/1/6
 */
public class CheckLinkedCyclic {

    public static class Node {

        public Node next;

    }


    public static boolean check(Node node) {
        Node fast = node.next;
        Node slow = node;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static boolean check2(Node node) {
        if (node == null ) {
            return false;
        }

        Node slow = node;
        Node fast = node.next;

        while (fast != null && fast.next != null) {
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }



    public static void main(String[] args) {

        Node n1 = new Node();
        Node n2 = new Node();
//        Node n3 = new Node();
//        Node n4 = new Node();
//        Node n5 = new Node();

        n1.next = n2;
        n2.next = n1;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//
//        n5.next = n1;


        System.out.println(check2(n1));
    }
}

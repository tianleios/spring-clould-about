package com.tl.algorithm.linkedList;

/**
 * Created by tianlei on 2019/1/6
 */
public class MergeLinkedList {





    public static void main(String[] args) {

        Node n1 = new Node();
        n1.value = 3;

        Node n2 = new Node();
        n2.value = 4;

        Node n3 = new Node();
        n3.value = 2;

        Node n4 = new Node();
        n4.value = 1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        int a = 10;
    }


    // 3 3 5 7
    // 1 2 6 8
    public static Node merge(Node l1, Node l2) {

        Node node = new Node();
        Node last = node;
        //
        while (l1 != null && l2 != null) {

            if (l1.value <= l2.value) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }

            last = last.next;
        }
        if (l1 == null) {
            last.next = l2;
        }
        if (l2 == null) {
            last.next = l1;
        }
        //
        return node.next;

    }

    public static Node merge2(Node l1, Node l2) {

        Node head = new Node();
        Node last = head;

        while (l1 != null && l2 != null) {

            if (l1.value >= l2.value) {
                last.next = l1;
                l1 = l1.next;

            } else {

                last.next = l2;
                l2 = l2.next;

            }

            last = last.next;
        }

        if (l1 == null) {
            last.next = l2;
        }

        if (l2 == null) {
            last.next = l1;
        }

        return head.next;

    }
}

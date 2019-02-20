package com.tl.algorithm.linkedList;

/**
 * Created by tianlei on 2019/1/6
 */
public class LinkedListQuickSort {



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

        quickSort2(n1, n4);

        Node.print(n1);
    }


    // 2 4 1 3
    public static void quickSort(Node head, Node end) {

        if (head != null && end != null && !head.equals(end)) {

            Node node = partion(head, end);

            quickSort(head, node);
            quickSort(node.next, end);

        }


    }

    // 3424 3244
    public static Node partion(Node begin, Node end) {

        Node first = begin;
        Node second = begin.next;

        while (second != null) {

            if (second.value >= first.value) {
                second = second.next;
            } else {
                first = first.next;

                int c = first.value;
                first.value = second.value;
                second.value = c;

                second = second.next;
            }

        }

        if (first != begin) {
            int c = first.value;
            first.value = begin.value;
            begin.value = c;
        }

        return first;
    }


    public static void quickSort2(Node head, Node end) {


        if (head != null && end != null && !head.equals(end)) {
            Node p = partion2(head, end);
            quickSort2(head, p);
            quickSort2(p.next, end);

        }

    }

    public static Node partion2(Node begin, Node end) {

        int temp = begin.value;

        Node l1 = begin;
        Node l2 = begin.next;

        while (l2 != null) {
            if (l2.value > temp) {
                l2 = l2.next;
            } else {

                l1 = l1.next;

                int c = l1.value;
                l1.value = l2.value;
                l2.value = c;


                l2 = l2.next;
            }
        }

        if (l1.value != begin.value) {
            int c = l1.value;
            l1.value = begin.value;
            begin.value = c;
        }

        return l1;

    }

}

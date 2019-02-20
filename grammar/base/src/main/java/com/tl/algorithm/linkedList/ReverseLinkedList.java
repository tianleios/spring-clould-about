package com.tl.algorithm.linkedList;

import org.junit.Test;

/**
 * Created by tianlei on 2019/2/14
 */
public class ReverseLinkedList {

    @Test
    public void test() {

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

        Node.print(n1);

        Node.print(reverse(n1));

    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p1 = head;
        Node p2 = head.next;
        Node p3;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;

            p1 = p2;
            p2 = p3;
        }

        head.next = null;
        return p1;


    }




}

package com.tl.algorithm.linkedList;

/**
 * Created by tianlei on 2019/2/14
 */
public class Node {
    public Integer value;
    public Node next;

    public static void print(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}

package com.tl.stream;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        Random random = new Random();

        for (;;) {
            System.out.println(random.nextInt(6));
        }

    }
}

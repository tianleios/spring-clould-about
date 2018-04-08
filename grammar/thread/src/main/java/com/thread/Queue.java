package com.thread;

import java.util.Collections;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Queue {

    public static void main(String[] args) {

        ThreadLocal
        ConcurrentHashMap
        //
        LinkedBlockingQueue linkedBlockingQueue =  new LinkedBlockingQueue<String>(2);

        try {

//            Collections.synchronizedMap()

            // 没有空位 会等待
            linkedBlockingQueue.put("first");
            linkedBlockingQueue.put("second");

            linkedBlockingQueue.offer("third",10, TimeUnit.SECONDS);


            // 没有东西会等待 take
            linkedBlockingQueue.take();

        } catch (Exception expection){

        }


    }
}
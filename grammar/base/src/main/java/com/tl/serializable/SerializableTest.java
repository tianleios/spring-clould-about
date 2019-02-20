package com.tl.serializable;

import java.io.*;

/**
 * Created by tianlei on 2018/12/26
 */
public class SerializableTest {


    static {
        System.out.println("123");
    }


    public static class Person implements Serializable {

        public String name;
    }

    public static void main(String[] args) throws Exception {

        SerializableTest.class.newInstance();

//        Person p = new Person();
//        p.name = "田磊";
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/Users/leitian/Desktop/person.txt")));
//        oos.writeObject(p);
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/Users/leitian/Desktop/person.txt") ));
//        Person inP = (Person) ois.readObject();
//
//        int a = 10;





    }
}

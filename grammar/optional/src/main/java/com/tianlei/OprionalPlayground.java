package com.tianlei;

import java.util.Optional;

public class OprionalPlayground {

    public static void main(String[] args) {


        Optional<String> optionalS = Optional.of("name");
        Optional<String> optionalMaybeNull = Optional.ofNullable(null);
        optionalS.ifPresent(s -> {

            System.out.println(s);

        });

        //
        optionalMaybeNull.ifPresent(System.out::println);

        System.out.println(optionalMaybeNull.orElse("it is null"));





        int a = 10;


    }
}

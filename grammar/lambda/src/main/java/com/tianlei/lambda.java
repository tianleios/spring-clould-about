package com.tianlei;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lambda {

    public static void main(String[] args) {

//        List<String> names = Arrays.asList("tian", "zhang", "li");
//
//        Collections.sort(names, (String a, String b) -> {
//            return a.compareTo(b);
//        });
//
//        Collections.sort(names, (String a, String b) -> a.compareTo(b));
//        Collections.sort(names, (a, b) -> a.compareTo(b));
//
//        //
//        names.stream().map()
//
//                .filter(s -> s.startsWith("1"))
//                .forEach(System.out::print);
//
//
//        //
//        String maybeNull = null;
//        Optional<String> stringOptional = new Optional<>(maybeNull);

//        stream();

        flatMap();
    }

    static void reduce() {

        // 指定初始值，进行求和累加
        Stream.of(1,2,4).reduce(0,(sum, item) -> {

            return sum + item;

        });


    }

    static void flatMap() {

        Stream<List<String>> moreStream = Stream.of(
                Arrays.asList("1","2","3"),
                Arrays.asList("4","5","6")
        );

        moreStream.flatMap(s -> {

            return s.stream();

        }).collect(Collectors.toList()).forEach(s -> {

        });


    }

    static void stream() {



//        Stream.of("1","2","3").reduce(obj,)



        Function<Integer,Integer> function = x -> 2 * x;

        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () ->  100;

        Predicate<Integer> predicate = x -> x > 0;





        List<String> names = Arrays.asList("1", "2", "3");
        names.stream().map(s -> s + s)
                .filter(s -> s.startsWith("12"))
                .forEach(System.out::println);

//        names.stream().red

        names.stream().map(s -> { return  "2";}).collect(Collectors.toSet());

    }

}

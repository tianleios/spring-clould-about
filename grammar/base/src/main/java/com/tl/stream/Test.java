package com.tl.stream;

import java.util.*;

public class Test {

    public static void main(String[] args) {


            List<Integer> list = Arrays.asList(1,2,3);

            Collections.sort(list, (o1, o2) -> {


                if (o1.compareTo(o2) == -1) {
                    return -1;
                }
                if (o1.compareTo(o2) == 1) {
                    return 1;
                }
                return 0;
                //return new CabinetSortUtil().compareLine(c1, c2);
            });

            System.out.println(list);



    }
}

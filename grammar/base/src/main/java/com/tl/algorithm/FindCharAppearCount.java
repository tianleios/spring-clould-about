package com.tl.algorithm;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by tianlei on 2019/2/25
 */
public class FindCharAppearCount {

    @Test
    public void mai() {

        String str = "aaabbccddd";
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();
        for (Character c : str.toCharArray()) {

            if (countMap.get(c) == null) {
                countMap.put(c, 1);
            } else {
                Integer count = countMap.get(c);
                countMap.put(c, count + 1);
            }

        }

        Character maxChar = null;
        Integer maxCount = 0;

       Iterator<Character> character =  countMap.keySet().iterator();
       while (character.hasNext()) {
          Character current =  character.next();
          Integer currentCount = countMap.get(current);
          if (maxChar == null) {
              maxChar = current;
              maxCount = currentCount;
          } else {
              if (currentCount.compareTo(maxCount) > 0) {
                  maxChar = current;
                  maxCount = currentCount;
              }
          }
       }

       System.out.println(maxChar);



    }
}

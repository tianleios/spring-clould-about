package com.tl.algorithm;

import java.util.LinkedHashMap;

/**
 * Created by tianlei on 2019/1/6
 */
public class LRU {




    public static class LRUMap<K, V>  {

        private Integer cacheSize;

        private LinkedHashMap<K, V> cacheMap;

        public  LRUMap(int maxSize) {
            cacheSize = maxSize;
            cacheMap = new LinkedHashMap<K, V>() {
//                @Override
//                protected boolean remove() {
//                    return size() > cacheSize;
//                }
//            };
            };
        }


    }


}

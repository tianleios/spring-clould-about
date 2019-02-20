package com.tl.algorithm;

import java.util.BitSet;

/**
 * Created by tianlei on 2019/1/6
 */
public class IpList {

    private static BitSet bitSet;

    public static void main(String[] args) {

        BitSet bitSet = new BitSet();
        bitSet.set(0, true);


        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(100));



//        System.out.println(Long.valueOf(ip));

    }


    public boolean isInList(String ip) {
        if (null == ip || ip.length() == 0) {
            return false;
        }

        return true;
//        return bitSet.get(convertIp(ip));
    }

    public Long convertIp(String ip) {

        return Long.valueOf(ip.replace(".",""));
    }


}

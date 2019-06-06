package com.tl.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianlei
 * @date 2019/04/14
 */
public class Discount {

    /**
     * 题目 商品 a b c ,a优惠 10， ab，优惠30，bc 优惠40，  购买5a, 6b, 3c最优惠金额
     *
     * 120 + 90 + 20
     *
     *
     *
     */
    public static void main(String[] args) {


        // 另外一体
        //1. 商品A, 每个用户前三件享受优惠，第四件起以原件购买
        //1. 商品A, 优惠库存为10件，超过10件需以原件购买

        // 商品A已经优惠8件，剩余优惠库存为2，用户b购买3件商品A
        // 用户B只能享受2件优惠，第三件原件

        Long itemId = 1L;
        Long userId = 10L;


        Map<Long, Integer> itemIdDiscountCountMap = new HashMap<Long, Integer>(){{
            put(itemId, 10);
        }};

        Map<Long, Integer> userIdBuyDiscountCountMap = new HashMap<>();




        //
        Integer buyCount = 5;


        Integer leftCount = itemIdDiscountCountMap.get(itemId);

        //
        Integer preCount = buyCount <= leftCount ? buyCount : leftCount;

        Integer buyDiscountCount = userIdBuyDiscountCountMap.get(userId);


        if (buyCount > 3) {
            // 全部原价;
        } else {
           Integer canCount = 3 - buyDiscountCount;
           if (preCount <= canCount) {
               // preCount 优惠   buyCount - preCount 原件
           } else {
               // canCount 优惠， buyCounr - canCount 原件
           }
        }







    }







}

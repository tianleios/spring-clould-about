package com.tl.algorithm;

/**
 * Created by tianlei on 2019/1/5
 */
public class AccountConvert {


    public static class Account {
        private Long amount;
        private Long id;

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }
    }


    public void convert(Long from, Long to, Long amonut, String orderNo) {

        assert null != from && null != to && amonut > 0;
        // redis 订单号 防重
        // 检查订单是否已处理
        // 间隔较长 检查该订单是否已处理

        //begin
        Account fromAcct;
        Account toAcct;
        if (from >= to) {
            //1. lock from
            //2. lock to
            fromAcct = getAcctForUpdate(from);
            toAcct = getAcctForUpdate(from);

        } else {
            //1. lock to
            //2. lock from
            toAcct = getAcctForUpdate(from);
            fromAcct = getAcctForUpdate(from);
        }

        if (fromAcct.getAmount() >= amonut) {
//            fromAcct.desc(amount);
//            toAcct.inc(amount);
        }


        //commmit
    }


    public Account getAcctForUpdate(Long id) {
        return new Account();
    }
}

package com.jiejing.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by xm on 18/1/10.
 */
@Data
public class CrmSmsDealVO {
    private Long id;

    private Long instId;

    /**
     * 短信条目数
     */
    private Integer number;

    /**
     * 总价
     */
    private Integer amount;

    /**
     * 实际支付
     */
    private Integer actualAmount;

    private Date gmtCreate;

    private Date gmtModify;

    /**
     * 订单状态
     1 : 新建订单
     2: 已支付

     */
    private Integer status;

    /**
     * 支付时间
     */
    private Date paymentTime;

    /**
     * 支付类型

     */
    private Integer paymentType;
}

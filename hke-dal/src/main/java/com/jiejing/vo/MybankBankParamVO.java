package com.jiejing.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by xm on 18/1/18.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MybankBankParamVO {

    private Long id;

    /**
     * 银行卡号
     备注：银行卡号、开户人名称及开户人证件号码等信息会进行核身，核身不通过无法完成商户进驻，合作方须注意银行卡信息的正确性。
     */
    private String bankCardNo;

    /**
     * 开户人名称。当商户类型是“01 自然人”、“02 个人工商户”时，开户人与须与负责人名称一致；当商户类型是“03 企业商户”时，须与企业法人名称一致。
     */
    private String bankCertName;

    private String accountType;

    private String contactLine;

    /**
     * 开户支行名称
     */
    private String branchName;

    /**
     * 开户支行所在省（按照附录5.6国标省市区号录入）
     */
    private String branchProvince;

    private String branchCity;

    /**
     * 持卡人证件类型。可选值：
     01：身份证
     对公账户不需要填写。
     */
    private String certType;

    private String certNo;

    /**
     * 持卡人地址
     对公账户不需要填写。
     */
    private String cardHolderAddress;

    /**
     * 对应机构id
     */
    private String outMerchantId;

    private Date gmtCreate;

    private Date gmtModify;

    private String bank;

    private String bankName;

    private Long instId;

    private String icon;
}

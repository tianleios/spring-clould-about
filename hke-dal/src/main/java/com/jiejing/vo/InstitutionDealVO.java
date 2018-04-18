package com.jiejing.vo;//package com.jiejing.model;

import com.jiejing.common.utils.TimeUtil;
import com.jiejing.model.InstitutionStudentCourse;
import com.jiejing.model.InstitutionStudentProduct;
import com.jiejing.model.Suite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder @Data @NoArgsConstructor @AllArgsConstructor public class InstitutionDealVO {
    private Long dealId;

    private String banner; //机构商标

    private Integer cashFee;

    private Date payTime; //付款时间

    private String payUrl;//付款链接

    private Date operatorTime;//最后付款时间

    private String transformFlowId; //转帐流水

    private Float feeRate; //手续费率

    private String bankName;
    private String bankArea;
    private String bankBelongName;

    private List<Suite> suiteList;
    private List<InstitutionStudentCourse> courseList;
    private List<InstitutionStudentProduct> productList;
    private List<InstitutionStudentCourse> changeCourseList;

    private Long instId;

    private String instMainPhone;

    private String instName;

    private Long belongId;

    private String belongName;

    private String phone;

    private Integer dealType;

    private Integer dealStatus;

    private Integer payStatus;

    private Integer payType;

    private String payAccount;

    private Long productId;

    private Integer productType;

    private String productName;

    private String attach;

    private Integer totalFee;

    private Integer deviceInfo;

    private Date gmtCreate;

    private Date gmtModify;


    private String productDetail;

    private String operatorTradeNo;

    private String operatorName1;

    private String operatorName2;

    private Integer balance;

    private String gmtCreateExport;

    private String balanceExport;

    private String totalFeeExport;

    private String dealStatusExport;

    public String getGmtCreateExport(){
        return TimeUtil.getFormatTimeStr(gmtCreate,"yyyy-MM-dd HH:mm:ss");
    }

    public String getBalanceExport(){
        String retStr = null;
        if(balance!= null) {
            double bExport = (double) balance / 100;
            retStr = String.valueOf(bExport);
        }
        return retStr;
    }

    public String getTotalFeeExport(){
        String retStr=null;
        if(totalFee!= null) {
            double tfExport = (double) totalFee / 100;
            retStr = String.valueOf(tfExport);
        }
        return retStr;
    }

//    public String getDealStatusExport(){
//        return DealStatus.fromCode(dealStatus).getDesc();
//    }
}

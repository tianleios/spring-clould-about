package com.jiejing.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionTrialLogVO {
    private Long id;

    private Long instId;

    private String instType;

    private String instName;

    private String phone;

    private String name;

    private Integer trialStatus;

    private String comment;

    private Date gmtCreate;

    private Date gmtModify;

    private String institutionType;

    //机构跟进状态
    private Integer sinstStatus;

    //机构操作状态
    private Integer operator;

    private String saleName;
}

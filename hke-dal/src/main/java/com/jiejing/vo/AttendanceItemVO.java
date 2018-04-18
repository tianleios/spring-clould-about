package com.jiejing.vo;

import lombok.Data;

/**
 * Created by xm on 17/4/18.
 */
@Data
public class AttendanceItemVO {

    private Long instId;

    private Long month;

    private Integer count;

    private Integer absentNumber;

    private Integer totalNumber;

    private String name;

    private Double percent;

    private Long refId;
}

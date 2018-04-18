package com.jiejing.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by xm on 18/2/6.
 * 班级请假次数
 */
@Builder
@Data
public class ClassLeaveCountDto {
    private Long classId;
    private BigDecimal count;
}

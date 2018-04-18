package com.jiejing.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by xm on 18/2/6.
 * 课程请假
 */
@Builder
@Data
public class CourseLeaveCountDto {
    private Long courseId;
    private BigDecimal count;
}

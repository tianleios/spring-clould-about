package com.jiejing.vo;

import com.jiejing.decorate.INameInstNameAble;
import lombok.Data;

/**
 * Created by xm on 17/9/26.
 * 供中心校区使用的子校区统计类
 */
@Data
public class SubInstStatVO implements INameInstNameAble{

    private Long instId;

    private String instName;

    private Integer studentCount;

    private Integer teacherCount;

    private Long adminId;

    private String contact;

    private String contactPhone;

//    private Integer earning;

    private Integer actualEarning;

    private Long expense;

    private Integer classHourCost;

    private Integer signUpCount;

}

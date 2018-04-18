package com.jiejing.vo;

import com.jiejing.decorate.INameInstNameAble;
import lombok.Data;

/**
 * Created by xm on 17/9/22.
 */
@Data
public class ExpenseDetailVO implements INameInstNameAble {

    private String name;
    private Long instId;
    private String instName;
    private Integer type;
    private String typeName;
    private Long value;
    private Double percent;
    private Integer rank;

    public double getFormatValue(){
        return value * 1d/100;
    }

}

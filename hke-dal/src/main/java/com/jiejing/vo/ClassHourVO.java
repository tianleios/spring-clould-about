package com.jiejing.vo;

import com.jiejing.decorate.INameInstNameAble;
import lombok.Data;

/**
 * Created by xm on 17/4/13.
 */
@Data
public class ClassHourVO implements INameInstNameAble{

    private Long instId;
    private String instName;
    private Long refId;
    private String name;
    private Integer type;
    private String typeName;
    private Long value;
    private Double percent;
    private Integer rank;

    public String getTypeName(){
        if(this.type!= null && type == 1){
            return "一对一";
        }else if (this.type != null && type == 3){
            return "一对多";
        }
        return "";
    }

    public double getFormatValue(){
        return value * 1d/100;
    }
}

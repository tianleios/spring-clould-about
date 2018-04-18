package com.jiejing.vo;

import com.jiejing.decorate.INameCourseNameAble;
import com.jiejing.decorate.INameInstNameAble;
import lombok.Data;

/**
 * Created by xm on 17/4/12.
 */
@Data
public class EarningItemVO implements INameInstNameAble,INameCourseNameAble{

    private Long instId;

    private String instName;

    private Long refId;
    private String name;
    private Integer type;
    private String typeName;
    private Integer earning;
    private Double formatEarning;
    private Double percent;
    private Integer rank;

    public String getTypeName(){
        if(type != null) {
            if (this.type > 0) {
                return "课程";
            } else {
                return "收费项";
            }
        }
        return null;
    }

    public double getFormatEarning() {
        if (earning != null) {
            return earning * 1d/100;
        }
        return 0.0;
    }

    //课程设置
    public Long getCourseId(){
        return refId;
    }

    public void setCourseName(String name){
        this.name = name;
    }

}

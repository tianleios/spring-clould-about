package com.jiejing.vo;

import lombok.Data;

/**
 * Created by xm on 17/9/25.
 * 报名人次
 */
@Data
public class SignUpVO {

    private Long instId;
    private String instName;
    private Long count;


    public static SignUpVO empty(){
        SignUpVO vo = new SignUpVO();
        vo.setCount(0l);
        vo.setInstId(null);
        vo.setInstName(null);
        return vo;
    }

}

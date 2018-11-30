package com.tianlei.req;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by tianlei on 2018/9/28
 */
public class Req {

    @NotBlank
    public String name;

    @Length(min = 6, max = 10, message = "长度错误")
    @NotBlank
    public String detail;

    @NotNull
    public Integer age;

}

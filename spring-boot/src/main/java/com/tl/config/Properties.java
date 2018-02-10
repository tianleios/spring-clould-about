package com.tl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 默认读取 application.properties 中 com.tianlei.location.* 的配置，与属性名称相同的配置
// 可以把配置信息加载进这个类
@ConfigurationProperties(prefix = "com.tianlei.location")
public class Properties {

    private String city;
    private String province;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}

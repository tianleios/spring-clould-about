package com.tl;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.tl.config.Config;
import com.tl.config.Config2;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;

// 1和2 两种配置方式相等
//1.
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//导入配置，Config2 没有使用 @Configuration注解，如果使用了。不用 @Import 也可以
//把配置加载进来,  @Import 应该和 @Configuration同时出现
//@Import(value = {Config2.class, Config.class})

//2.
@SpringBootApplication
@Import(value = {Config2.class, Config.class})

@EnableRabbit
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class);

    }

    @Bean
    public HttpMessageConverters fastjsonHttpMessageConverter(){

        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConvert.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConvert);

    }


}

package com.jiejing;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.jiejing.interceptor.CrossOriginInterceptor;
import com.jiejing.swagger.SwaggerFastJsonHttpMessageConverter4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.List;

/**
 * Created by baihe on 16/7/8.
 */
@SpringBootApplication(scanBasePackages = "com.jiejing")
@ImportResource("classpath*:com/jiejing/spring/applicationContext-*.xml")
public class GatewayApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossOriginInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SwaggerFastJsonHttpMessageConverter4 fastConverter = new SwaggerFastJsonHttpMessageConverter4();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNonStringKeyAsString,
            SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConfig.setSerializeFilters(new ValueFilter() {
            @Override public Object process(Object object, String name, Object value) {
                if (value instanceof Long) {
                    return value.toString();
                }
                if (value instanceof Date) {
                    return String.valueOf(((Date) value).getTime());
                }
                return value;
            }
        });
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }
}

package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGloable(AuthenticationManagerBuilder managerBuilder) throws Exception {

        //这里可以进行认证配置， 类似于shiro realm 中 doGetAuthenticationInfo
//        managerBuilder.inMemoryAuthentication()
//                .withUser("user").password("password").roles("superAdmin");

        managerBuilder.userDetailsService(new MyUserDetailsService());

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*").permitAll();
        // @formatter:on

        http.userDetailsService(new MyUserDetailsService());
    }
}

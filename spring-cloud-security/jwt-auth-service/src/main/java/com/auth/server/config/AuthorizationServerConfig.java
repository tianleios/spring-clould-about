package com.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.HashMap;
import java.util.Map;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置两个客户端,一个用于password认证一个用于client认证
        clients.inMemory().withClient("client_1")
//                .resourceIds(DEMO_RESOURCE_ID) // 如果使用，该id 要和 资源服务器的resourceId相同
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("123456")
                .and().withClient("client_2")
//                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("123456");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(this.tokenStore())
                .accessTokenConverter(this.jwtAccessTokenConverter())
                .authenticationManager(authenticationManager);
//        endpoints.userDetailsService(new MyUserDetailsService());

//        endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer()).authenticationManager(authenticationManager);

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients();
    }


    @Bean
    public TokenStore tokenStore() {

        TokenStore tokenStore = new JwtTokenStore(this.jwtAccessTokenConverter());
        return tokenStore;

    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {

        //应该换成 公钥加密 私钥解密
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter(){
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

               String userName =  authentication.getUserAuthentication().getName();
               User user = (User) authentication.getUserAuthentication().getPrincipal();
               //
                Map<String, Object> additionalInformation = new HashMap<>();
                additionalInformation.put("userName",userName);
                additionalInformation.put("roles",user.getAuthorities());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken enhancedToken = super.enhance(accessToken,authentication);
                return super.enhance(accessToken, authentication);

            }

        };

        jwtAccessTokenConverter.setSigningKey("signKey");

        return jwtAccessTokenConverter;

    }


}

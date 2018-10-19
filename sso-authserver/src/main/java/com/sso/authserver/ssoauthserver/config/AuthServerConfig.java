package com.sso.authserver.ssoauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * 认证配置
 * 重写WebSecurityConfigurerAdapter 否则所有的路径都会受到SSO的保护
 * 无论用户访问哪个页面都会被重定向到登录页面
 * 在这个例子中，index和login页面是唯一不需要被防护的
 */
@Configuration
@EnableAuthorizationServer  // @EnableOAuth2Sso注解来开启SSO
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("SampleClientId")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("user_info")
                .autoApprove(true)
                .redirectUris("http://localhost:8082/ui/login","http://localhost:8083/ui2/login","http://localhost:8082/login");
        // .accessTokenValiditySeconds(3600);   //1 hour
    }

}
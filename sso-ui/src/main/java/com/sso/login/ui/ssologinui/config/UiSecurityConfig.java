package com.sso.login.ui.ssologinui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 客户端安全配置
 * 重写WebSecurityConfigurerAdapter 否则所有的路径都会受到SSO的保护
 * 无论用户访问哪个页面都会被重定向到登录页面
 * 在这个例子中，index和login页面是唯一不需要被防护的
 */
@Configuration
@EnableOAuth2Sso // @EnableOAuth2Sso注解来开启SSO
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
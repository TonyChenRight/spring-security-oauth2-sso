package com.sso.authserver.ssoauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer   //开启资源服务器
@SpringBootApplication
public class SsoAuthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoAuthserverApplication.class, args);
	}
}

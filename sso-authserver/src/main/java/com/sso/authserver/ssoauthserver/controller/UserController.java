package com.sso.authserver.ssoauthserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 用户controller
 */
@RestController
public class UserController {

    /**
     * 终端获取用户信息
     * @param principal
     * @return
     */
    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
}
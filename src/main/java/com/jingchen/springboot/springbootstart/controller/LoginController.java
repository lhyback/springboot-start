/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jingchen.lhy
 * @version $Id: LoginController.java, v 0.1 2019年07月10日 15:50 jingchen.lhy Exp $
 */
@Controller
public class LoginController {
    /**
     * 登录请求直接到login页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
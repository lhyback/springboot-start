/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.controller;

import com.jingchen.springboot.springbootstart.common.ServerResponse;
import com.jingchen.springboot.springbootstart.dataobject.User;
import com.jingchen.springboot.springbootstart.exception.MyException;
import com.jingchen.springboot.springbootstart.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jingchen.lhy
 * @version $Id: UserController.java, v 0.1 2019年07月09日 19:25 jingchen.lhy Exp $
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public ServerResponse addUser(@RequestBody User user) throws Exception {
        if (user == null || user.getName() == null) {
            LOGGER.info("用户参数有误");
            throw new MyException("用户参数有误");
        }
        if (userService.addUser(user) > 0) {
            return ServerResponse.createSuccess("插入用户成功");
        } else {
            return ServerResponse.createError("用户已存在，插入失败");
        }
    }


}
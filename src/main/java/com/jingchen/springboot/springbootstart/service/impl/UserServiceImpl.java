/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.service.impl;

import com.jingchen.springboot.springbootstart.dataobject.User;
import com.jingchen.springboot.springbootstart.mapper.UserMapper;
import com.jingchen.springboot.springbootstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author jingchen.lhy
 * @version $Id: UserServiceImpl.java, v 0.1 2019年07月09日 19:45 jingchen.lhy Exp $
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        if (user == null || StringUtils.isEmpty(user.getName())) {
            return 0;
        }
        if (getUserByName(user.getName()) != null) {
            return 0;
        }
        return userMapper.insert(user);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.selectByName(name);
    }
}
/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.service;

import com.jingchen.springboot.springbootstart.dataobject.User;

/**
 *
 * @author jingchen.lhy
 * @version $Id: UserService.java, v 0.1 2019年07月09日 19:43 jingchen.lhy Exp $
 */
public interface UserService {
    int addUser(User user);

    User getUserByName(String name);
}
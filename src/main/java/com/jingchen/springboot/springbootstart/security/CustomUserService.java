/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.security;

import com.jingchen.springboot.springbootstart.dataobject.Permission;
import com.jingchen.springboot.springbootstart.dataobject.User;
import com.jingchen.springboot.springbootstart.mapper.PermissionMapper;
import com.jingchen.springboot.springbootstart.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jingchen.lhy
 * @version $Id: CustomUserService.java, v 0.1 2019年07月10日 13:43 jingchen.lhy Exp $
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Permission> permissionList = permissionMapper.selectByRoleId(user.getRoleId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : permissionList) {
            authorities.add(new SimpleGrantedAuthority(permission.getTitle()));
        }

        //这里是Spring Security鉴权用的 User
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }
}
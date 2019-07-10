/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.config;

import com.jingchen.springboot.springbootstart.common.WebConstants;
import com.jingchen.springboot.springbootstart.security.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author jingchen.lhy
 * @version $Id: WebSecurityConfig.java, v 0.1 2019年07月10日 11:03 jingchen.lhy Exp $
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("*.json").hasRole(WebConstants.Permission.GL_API.getCode())
                .antMatchers("/admin/*.json").hasRole(WebConstants.Permission.GL_ADMIN_API.getCode())
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    /**
     * 对默认的AuthenticationManagerBuilder进行设置
     * @param auth
     * @throws Exception
     */
    //@Autowired
    //public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //    //简单的单个用户
    //    auth
    //        .inMemoryAuthentication()
    //            .withUser("user").password("password").roles("USER");
    //}


    /**
     * 自定义UserDetailsService(含认证逻辑)
     * @return
     */
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }
}
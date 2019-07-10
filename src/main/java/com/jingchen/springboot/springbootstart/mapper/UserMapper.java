/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.mapper;

import com.jingchen.springboot.springbootstart.dataobject.User;
import org.apache.ibatis.annotations.*;

/**
 *
 * @author jingchen.lhy
 * @version $Id: UserMapper.java, v 0.1 2019年07月09日 17:26 jingchen.lhy Exp $
 */
@Mapper
public interface UserMapper {

    @Results({
            @Result(property = "roleId", column = "role_id")
    })
    @Select("SELECT * FROM user WHERE name = #{name}")
    User selectByName(@Param("name") String name);

    @Insert("INSERT INTO user(name, age) VALUES (#{name}, #{age})")
    int insert(User user);
}
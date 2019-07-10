/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.mapper;

import com.jingchen.springboot.springbootstart.dataobject.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * @author jingchen.lhy
 * @version $Id: PermissionMapper.java, v 0.1 2019年07月10日 14:57 jingchen.lhy Exp $
 */
@Mapper
public interface PermissionMapper {
    @Select("SELECT p.id,title,description FROM permission p"
            + " INNER JOIN role_permission rp ON p.id = rp.permission_id"
            + " WHERE rp.role_id = #{roleId}")
    List<Permission> selectByRoleId(@Param("roleId") Integer roleId);
}
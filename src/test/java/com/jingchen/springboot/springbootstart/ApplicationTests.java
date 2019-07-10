package com.jingchen.springboot.springbootstart;

import com.jingchen.springboot.springbootstart.controller.HelloController;
import com.jingchen.springboot.springbootstart.dataobject.Permission;
import com.jingchen.springboot.springbootstart.dataobject.User;
import com.jingchen.springboot.springbootstart.mapper.PermissionMapper;
import com.jingchen.springboot.springbootstart.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private MockMvc mvc;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void testUser() {
        System.out.println(userMapper.selectByName("新世界"));
    }

    @Test
    public void testPermission() {
        List<Permission> permissions = permissionMapper.selectByRoleId(1);
        System.out.println(permissions);
    }

}

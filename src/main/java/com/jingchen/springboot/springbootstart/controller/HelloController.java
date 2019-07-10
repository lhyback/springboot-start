/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jingchen.springboot.springbootstart.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jingchen.lhy
 * @version $Id: HelloController.java, v 0.1 2019年07月09日 14:02 jingchen.lhy Exp $
 */
@Controller
public class HelloController {
    //slf4j
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private AtomicLong id = new AtomicLong(1);

    @Value("${com.jingchen.demo.title}")
    private String app;

    /**
     * 返回个string就能定位到页面(默认视图解析)
     * @return
     */
    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * 返回html页面
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/somepage")
    public String getSomePage(ModelAndView modelAndView) {
        //返回字符串，thy有默认的视图解析
        modelAndView.addObject("app", app);
        return "somepage";
    }

    /**
     * 尝试自定义异常统一处理
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/tryException.json")
    public String tryException() throws Exception {
        throw new Exception("人造异常");
    }


    /**
     * 返回json数据
     *
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping("/hello.json")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "stranger") String name) {
        Greeting greeting = new Greeting();
        greeting.setId(id.getAndIncrement());
        greeting.setName(name);
        LOGGER.info("app={}, sayhello to {}", app, greeting);
        return greeting;
    }


    private static class Greeting {
        private Long   id;
        private String name;

        @JsonIgnore
        private Integer age;

        /**
         * Getter method for property <tt>id</tt>.
         *
         * @return property value of id
         */
        public Long getId() {
            return id;
        }

        /**
         * Setter method for property <tt>id</tt>.
         *
         * @param id value to be assigned to property id
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * Getter method for property <tt>name</tt>.
         *
         * @return property value of name
         */
        public String getName() {
            return name;
        }

        /**
         * Setter method for property <tt>name</tt>.
         *
         * @param name value to be assigned to property name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Getter method for property <tt>age</tt>.
         *
         * @return property value of age
         */
        public Integer getAge() {
            return age;
        }

        /**
         * Setter method for property <tt>age</tt>.
         *
         * @param age value to be assigned to property age
         */
        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Greeting{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
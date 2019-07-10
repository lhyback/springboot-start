/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.exception;

import com.jingchen.springboot.springbootstart.common.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 不用在每个Controller中定义异常处理，用统一的异常处理器
 * @author jingchen.lhy
 * @version $Id: GlobalExceptionHandler.java, v 0.1 2019年07月09日 15:38 jingchen.lhy Exp $
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_SERVER_ERROR_VIEW = "500";

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 返回json错误体
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MyException.class)
    public ServerResponse myExceptionHandler(MyException e) {
        ServerResponse response = ServerResponse.createError(e.getMessage());
        response.setCode("1001");
        return response;
    }

    /**
     * 返回错误页面，异常处理这要返回modelAndView，而不是只返回个string供视图解析器解析
     *
     * @param request
     * @param e 需要catch处理的异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception e) {
        LOGGER.error("捕获最终未处理异常, e={}", e.getMessage(), e);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(DEFAULT_SERVER_ERROR_VIEW);
        return modelAndView;
    }

}
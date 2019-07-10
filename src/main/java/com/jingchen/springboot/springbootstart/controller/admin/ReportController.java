/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.controller.admin;

import com.jingchen.springboot.springbootstart.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jingchen.lhy
 * @version $Id: ReportController.java, v 0.1 2019年07月10日 16:42 jingchen.lhy Exp $
 */
@Controller
@RequestMapping("/admin/report")
public class ReportController {
    @ResponseBody
    @RequestMapping("/query.json")
    public ServerResponse getReport() {
        return ServerResponse.createSuccess("这是ADMIN才能调用的接口");
    }
}
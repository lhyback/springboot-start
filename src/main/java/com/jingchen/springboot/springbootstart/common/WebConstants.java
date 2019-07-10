/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.common;

/**
 *
 * @author jingchen.lhy
 * @version $Id: WebConstants.java, v 0.1 2019年07月10日 15:09 jingchen.lhy Exp $
 */
public interface WebConstants {
    enum Permission {
        GL_API("GL_API"),
        GL_ADMIN_API("GL_ADMIN_API");

        String code;

        Permission(String code) {
            this.code = code;
        }

        /**
         * Getter method for property <tt>code</tt>.
         *
         * @return property value of code
         */
        public String getCode() {
            return code;
        }
    }
}
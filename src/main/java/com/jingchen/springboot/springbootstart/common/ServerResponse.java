/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jingchen.springboot.springbootstart.common;

/**
 *
 * @author jingchen.lhy
 * @version $Id: ServerResponse.java, v 0.1 2019年07月09日 19:27 jingchen.lhy Exp $
 */
public class ServerResponse<T> {
    private Boolean success;
    private T data;
    private String message;
    private String code;

    private ServerResponse(){}

    public static ServerResponse createSuccess(String message, Object data) {
        ServerResponse response = createSuccess(message);
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static ServerResponse createSuccess(String message) {
        ServerResponse response = new ServerResponse<>();
        response.setCode("0");
        response.setMessage(message);
        response.setSuccess(true);
        return response;
    }

    public static ServerResponse createError(String message, String code) {
        ServerResponse response = createError(message);
        response.setCode(code);
        return response;
    }

    public static ServerResponse createError(String message) {
        ServerResponse response = new ServerResponse<>();
        response.setCode("1");
        response.setMessage(message);
        response.setSuccess(false);
        return response;
    }




    /**
     * Getter method for property <tt>success</tt>.
     *
     * @return property value of success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public T getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
package com.learnspringboot.response;/*
 * Project: springboot03
 * File Created at 2021-07-07 22:05:22:05
 * @Type Response.java
 * @Desc
 * @author <a href="mailto:">chenming</a>
 * @date 2021/7/7 0007 22:05
 * @version 1.0.0
 */

import java.io.Serializable;

public class Response implements Serializable {
    public static final int SUCCESS = 200;
    private int code;
    private String message;
    private Object body;
    private Long timestamp;

    public Response() {
    }

    public Response(Object body) {
        this(SUCCESS, "成功",body);
    }

    public Response(int code, String message, Object body) {
        this.code = code;
        this.message = message;
        this.body = body;
        this.timestamp = System.currentTimeMillis();
    }

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static Response ok(Object body){
        return new Response(body);
    }

    public static Response error(int code, String message) {
        return new Response(code, message, null);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", body=" + body +
                ", timestamp=" + timestamp +
                '}';
    }
}

package com.learn.boot.config;

import com.learn.boot.bean.MyClass;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-12 16:10:16:10
 * {@link}
 * 扩展客户端accept类型
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type MyAcceptHttpMessageConvert.java
 * @Desc
 * @date 2022/3/12 16:10
 */
public class MyAcceptHttpMessageConvert implements HttpMessageConverter<MyClass> {
    /**
     * 设置接收的参数类型,自己定义,默认为false,表示不去解析
     */
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }
    /**设置要写出的内容需要满足的条件,这里设置只写出MyClass类型*/
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(MyClass.class);
    }
    /**统计能写出的媒体类型*/
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/self-type");
    }

    @Override
    public MyClass read(Class<? extends MyClass> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(MyClass myClass, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议类型写出
        String data = myClass.toString();
        OutputStream body = outputMessage.getBody();
        // 写出
        body.write(data.getBytes());

    }
}

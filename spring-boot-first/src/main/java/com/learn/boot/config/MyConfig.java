package com.learn.boot.config;

import com.learn.boot.bean.Pet;
import com.learn.boot.bean.Student;
import com.learn.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-02 16:54:16:54
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type MyConfig.java
 * @Desc
 * @date 2022/3/2 16:54
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Bean
    @ConditionalOnBean(name = "pig")
    public User user01(Pet pig) {
        User user = new User("zhangsan", 22);
        user.setPet(pig());
        return user;
    }

    @Bean
    public Pet pig() {
        return new Pet("peggy");
    }
    /**
     * 开启springboot支持矩阵变量
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(true);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypes = new HashMap<>();
        // 指定参数解析媒体类型
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("self", MediaType.parseMediaType("application/self-type"));

        ParameterContentNegotiationStrategy pcns = new ParameterContentNegotiationStrategy(mediaTypes);
        // 支持请求头accept,没有这个 header 所有accept类型都会返回json，通过源码确定
        HeaderContentNegotiationStrategy header = new HeaderContentNegotiationStrategy();
        configurer.strategies(Arrays.asList(pcns,header));
    }

    /**
     * 自定义类型转化器
     * 支持自定义表单属性绑定比如
     * 宠物姓名:<input name="student" value="老王,20"><br/>
     * 通过以下转化器可以将"老王,20"封装成Student对象
     */
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new Converter<String, Student>() {
            @Override
            public Student convert(String source) {
                String[] split = source.split(",");
                Student student = new Student();
                student.setAge(Integer.parseInt(split[1]));
                student.setName(split[0]);
                return student;
            }
        });
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        RequestInteceptor inteceptor = new RequestInteceptor();
        registry.addInterceptor(inteceptor)
        .addPathPatterns("/**")//拦截所有请求
        .excludePathPatterns(Arrays.asList("/","/login","/error","/css/**","/js/**","/images/**"))//放行请求列表:指定路径和静态资源
        ;
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("rest_method");
        return hiddenHttpMethodFilter;
    }
    /**扩展 客户端accept自定义类型*/
    @Override
    public  void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyAcceptHttpMessageConvert());
    }
}

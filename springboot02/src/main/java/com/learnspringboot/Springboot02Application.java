package com.learnspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.learnspringboot.mapper")//用于扫描mapper接口生成代理对象
public class Springboot02Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot02Application.class, args);
	}

}

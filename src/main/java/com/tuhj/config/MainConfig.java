package com.tuhj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tuhj.bean.Person;

// 配置类==配置文件
@Configuration // 告诉Spring这是一个配置类
@ComponentScan(value = "com.tuhj",includeFilters = {
		@Filter(type=FilterType.ANNOTATION,classes= {Controller.class,Service.class})
},useDefaultFilters = false)	
// @ComponentScan	包扫描注解，value指定需要扫描的包
// excludeFilters = Filter[]，指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[]，指定扫描的时候只需要哪些组件 ；默认扫描所有组件，需要添加 useDefaultFilters = false

public class MainConfig {

	// 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	@Bean
	public Person person() {
		return new Person("lisi", 20);
	}
}

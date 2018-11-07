package com.tuhj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tuhj.bean.Person;
import com.tuhj.service.BookService;

// 配置类==配置文件
@Configuration // 告诉Spring这是一个配置类
//@ComponentScan(value = "com.tuhj",includeFilters = {
//		@Filter(type=FilterType.ANNOTATION,classes= {Controller.class,Service.class})
//},useDefaultFilters = false)
@ComponentScans(
		value = {
				@ComponentScan(value = "com.tuhj",includeFilters = {
//						@Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//						@Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
						@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
				},useDefaultFilters = false)
		}
		)
// @ComponentScan	包扫描注解，value指定需要扫描的包
// excludeFilters = Filter[]，指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[]，指定扫描的时候只需要哪些组件 ；默认扫描所有组件，需要添加 useDefaultFilters = false，禁用默认规则
// FilterType.ANNOTATION 按照注解
// FilterType.ASSIGNABLE_TYPE 按照类型
// FilterType.ASPECTJ 使用ASPECTJ表达式
// FilterType.REGEX 使用正则表达式
// FilterType.CUSTOM 使用自定义，指定包com.tuhj下的所有类都会进入MyTypeFilter的规则进行匹配 

public class MainConfig {

	// 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	@Bean
	public Person person() {
		return new Person("lisi", 20);
	}
}

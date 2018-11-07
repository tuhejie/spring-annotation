package com.tuhj.config;

import java.util.concurrent.SynchronousQueue;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.tuhj.bean.Person;

@Configuration
public class MainConfig2 {
	
	/**
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * 
	 * @Scope：调整作用域
	 * 
	 * prototype：多实例的，ioc容器启动不会调用方法创建对象放到容器中；每次获取的时候才会调用方法创建对象
	 * singleton：单实例的（默认的），ioc容器启动会调用方法创建对象放到ioc容器中
	 * request：同义词请求创建一个实例
	 * session：同一个session创建一个实例
	 * 
	 * @Lazy：懒加载（专门针对单实例）
	 * 		单实例bean，默认在容器启动的时候创建对象；
	 * 		懒加载：容器启动不创建对象，第一次使用（获取）Bean时创建对象，并初始化；
	 * 
	 */
//	@Scope("singleton")
	@Lazy
	@Bean("person")
	public Person person() {
		System.out.println("给容器中添加Person...");
		return new Person("张三", 25);
	}
	
}

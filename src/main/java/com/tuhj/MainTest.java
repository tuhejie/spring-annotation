package com.tuhj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tuhj.bean.Person;
import com.tuhj.config.MainConfig;

public class MainTest {
	public static void main(String[] args) {
		
		// 1.配置文件的方式获取bean
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);
		
		// 2.配置类的方式获取bean
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		
	}
}

package com.example.demo;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executor {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationResources.xml");
		IHello hello = (IHello)ctx.getBean("hello");
		hello.sayHello();
		
		AutowireCapableBeanFactory bf = ctx.getAutowireCapableBeanFactory();
		GenericBeanDefinition gbd = new GenericBeanDefinition();
		gbd.setBeanClass(HelloUAService.class);
		gbd.setAutowireCandidate(true);
		gbd.setScope("singleton");
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) bf;
		registry.registerBeanDefinition("helloUA", gbd);
		IHello helloUA = (IHello)bf.createBean(HelloUAService.class);
		helloUA.sayHello();

	}

}

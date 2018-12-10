/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import test.spring.helloworld.IHelloWorld;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int instantiatMeans = 0;
		BeanFactory factory;
		switch (instantiatMeans) {
		case 1:
			//Instantiat Container 1
			Resource resource = new FileSystemResource("beans.xml");
			factory = new XmlBeanFactory(resource);			
			break;
		case 2:
			//Instantiat Container 2
			ClassPathResource resource2 = new ClassPathResource("beans.xml");
			factory = new XmlBeanFactory(resource2);
			break;
		case 3:
			//Instantiat Container 3
			ApplicationContext context1 = new ClassPathXmlApplicationContext(
			        new String[] {"appContext.xml"});
			// of course, an ApplicationContext is just a BeanFactory
			factory = (BeanFactory) context1;
			break;
		default:
			factory = new ClassPathXmlApplicationContext("appContext.xml");
			break;
		}
				
		IHelloWorld helloWorld = (IHelloWorld) factory.getBean("anotherHelloWorld");
		helloWorld.sayGreeting();
		IHelloWorld helloWorld1 = (IHelloWorld) factory.getBean("anotherHelloWorld");
		System.out.println(helloWorld.equals(helloWorld1));
		System.out.println(helloWorld == helloWorld1);
	}
}

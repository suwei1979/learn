/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.beanfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * ��ʾͨ��������ע��factory-bean��factory-provider����Ĳ���
 * 
 * @author worldheart
 */
public class BeanFactoryDemo6 {

	protected static final Log log = LogFactory.getLog(BeanFactoryDemo6.class);

	public void getContent() {
		// ��classpath·����װ��XML������Ϣ
		Resource resource = new ClassPathResource("beanFactory6.xml");
		// ʵ����IoC����
		BeanFactory factory = new XmlBeanFactory(resource);
		// ����ܹ�POJO
		ITestBean tb1 = (ITestBean) factory.getBean("test.TestBean");
		ITestBean testBean = (ITestBean) factory.getBean("testBean");
		ITestBean tB = (ITestBean) factory.getBean("tB");
		ITestBean tb = (ITestBean) factory.getBean("tb");
	}

	public static void main(String[] args) {
		BeanFactoryDemo6 bfd = new BeanFactoryDemo6();
		bfd.getContent();
	}

}
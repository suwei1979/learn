/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
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
public class BeanFactoryDemo5 {

    protected static final Log log = LogFactory.getLog(BeanFactoryDemo5.class);

    public static void main(String[] args) {
        BeanFactoryDemo5 bfd = new BeanFactoryDemo5();
        bfd.getContent();
    }

    public void getContent() {
        //��classpath·����װ��XML������Ϣ
        Resource resource = new ClassPathResource("beanFactory5.xml");
        //ʵ����IoC����
        BeanFactory factory = new XmlBeanFactory(resource);
        //����ܹ�POJO
        IHelloWorld hw1 = (IHelloWorld) factory.getBean("helloWorld1");
        //����ַ���
        log.info(hw1.getContent());
        //����ܹ�POJO
        IHelloWorld hw2 = (IHelloWorld) factory.getBean("helloWorld2");
        //����ַ���
        log.info(hw2.getContent());
    }

}
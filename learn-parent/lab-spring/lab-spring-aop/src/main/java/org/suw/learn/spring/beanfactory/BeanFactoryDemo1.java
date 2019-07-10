/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beanfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * HelloWorld�ͻ�Ӧ��
 *
 * @author worldheart
 */
public class BeanFactoryDemo1 {

    protected static final Log log = LogFactory.getLog(BeanFactoryDemo1.class);

    public static void main(String[] args) {
        BeanFactoryDemo1 bfd = new BeanFactoryDemo1();
        log.info(bfd.getContent());
    }

    public String getContent() {
        Resource resource = new ClassPathResource("beanFactory1.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IHelloWorld hw = (IHelloWorld) factory.getBean("helloWorld");
        return hw.getContent();
    }

}
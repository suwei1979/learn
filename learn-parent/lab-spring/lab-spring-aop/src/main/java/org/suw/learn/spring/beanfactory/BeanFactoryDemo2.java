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
 * ��ʾfactory-provider
 *
 * @author worldheart
 */
public class BeanFactoryDemo2 {

    protected static final Log log = LogFactory.getLog(BeanFactoryDemo2.class);

    public static void main(String[] args) {
        BeanFactoryDemo2 bfd = new BeanFactoryDemo2();
        //������ؽ��
        log.info(bfd.getContent());
    }

    public String getContent() {
        //��classpath·����װ��XML������Ϣ
        Resource resource = new ClassPathResource("beanFactory2.xml");
        //ʵ����IoC����
        BeanFactory factory = new XmlBeanFactory(resource);
        //����ܹ�POJO
        IHelloWorld hw = (IHelloWorld) factory.getBean("helloWorld");
        //�����ַ���
        return hw.getContent();
    }

}
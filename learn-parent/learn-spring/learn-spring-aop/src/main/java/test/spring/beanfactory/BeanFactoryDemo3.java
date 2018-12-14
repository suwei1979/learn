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
 * ��ʾfactory-bean��factory-provider���޴��������
 *
 * @author worldheart
 */
public class BeanFactoryDemo3 {

    protected static final Log log = LogFactory.getLog(BeanFactoryDemo3.class);

    public static void main(String[] args) {
        BeanFactoryDemo3 bfd = new BeanFactoryDemo3();
        //������ؽ��
        log.info(bfd.getContent());
    }

    public String getContent() {
        //��classpath·����װ��XML������Ϣ
        Resource resource = new ClassPathResource("beanFactory3.xml");
        //ʵ����IoC����
        BeanFactory factory = new XmlBeanFactory(resource);
        //����ܹ�POJO
        IHelloWorld hw = (IHelloWorld) factory.getBean("helloWorld");
        //�����ַ���
        return hw.getContent();
    }

}
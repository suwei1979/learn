/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.beanfactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * �����ļ���ʽ����ȡHelloWorld������ַ�����
 *
 * @author worldheart
 */
public class FileHelloStrImpl implements IHelloStr {

    protected static final Log log = LogFactory.getLog(FileHelloStrImpl.class);

    private String propfilename;

    private ITestBean tbean;

    public FileHelloStrImpl(String propfilename) {
        this.propfilename = propfilename;
    }

    public FileHelloStrImpl(String propfilename, ITestBean testBean) {
        this.propfilename = propfilename;
        this.tbean = testBean;
    }

    public FileHelloStrImpl(ITestBean testBean, String propfilename) {
        this.tbean = testBean;
        this.propfilename = propfilename;
    }

    public String getContent() {
        String helloworld = "";

        try {
            Properties properties = new Properties();
            //����������
            InputStream is = getClass().getClassLoader().getResourceAsStream(
                    propfilename);
            properties.load(is);
            is.close();
            //���helloworld����Ӧ��ȡֵ
            helloworld = properties.getProperty("helloworld");
        } catch (FileNotFoundException ex) {
            log.error(ex);
        } catch (IOException ex) {
            log.error(ex);
        }

        return helloworld;
    }

}
/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package test.spring.beanfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ���HelloWorld�ַ���
 *
 * @author worldheart
 */
public class HelloWorld implements IHelloWorld {

    protected static final Log log = LogFactory.getLog(HelloWorld.class);

    private IHelloStr helloStr;

    public static HelloWorld getHelloWorld() {
        return new HelloWorld();
    }

    public static HelloWorld getHelloWorld(IHelloStr helloStr) {
        HelloWorld hw = new HelloWorld();
        hw.setHelloStr(helloStr);
        return hw;
    }

    public void setHelloStr(IHelloStr str) {
        this.helloStr = str;
    }

    public String getContent() {
        return helloStr.getContent();
    }

    public HelloWorld makeHelloWorld() {
        return new HelloWorld();
    }

    public HelloWorld makeHelloWorld(IHelloStr helloStr) {
        HelloWorld hw = new HelloWorld();
        hw.setHelloStr(helloStr);
        return hw;
    }

}
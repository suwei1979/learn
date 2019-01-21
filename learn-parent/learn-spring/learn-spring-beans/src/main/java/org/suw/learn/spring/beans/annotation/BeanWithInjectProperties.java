/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beans.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @classname: BeanWithInjectProperties
 * @author: suwei
 * @description:
 * @date: created in 2019/1/8 : 4:02 PM
 * @modified
 **/
@Data
@Component
public class BeanWithInjectProperties {

    @Value("normal")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    @Value("#{T(java.lang.Math).random()}")
    private double randomNumber;

    @Value("#{beanInject.another}")
    private String fromAnotherBean;

    @Value("classpath:config.txt")
    private Resource configFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

}

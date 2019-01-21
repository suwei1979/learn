/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beans.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @classname: BeanInject
 * @author: suwei
 * @description:
 * @date: created in 2019/1/8 : 7:14 PM
 * @modified
 **/
@Data
@Component
public class BeanInject {
    @Value("propertyOfAnotherBean")
    String another;
}

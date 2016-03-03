/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suwei
 *
 */
@Slf4j
public class TechnicalExample {
    private PagingRepository<Account, TestPageRequest, Long> listAccountRepo;

    public void test() {
        listAccountRepo.listByPage(null);
    }
    
    public static void main(String[] args) throws Exception {
        TechnicalExample testService = new TechnicalExample();
        Field field = testService.getClass().getDeclaredField("listAccountRepo");
        log.debug("The field type is " + field.getType());
        log.debug(
                "The field type is equals to ListRepository: " + PagingRepository.class.isAssignableFrom(field.getType()));
        log.debug("The actrual parameter type[0] is: "
                + ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
        
        boolean accessible = field.isAccessible();
        Object proxy = Proxy.newProxyInstance(testService.getClass().getClassLoader(), new Class[]{PagingRepository.class}, new RepositoryProxy());
        field.setAccessible(true);
        field.set(testService , proxy);
        field.setAccessible(accessible);
        
        testService.test();
        ClassB classB = new ClassB();
        ClassA classA = new ClassA(classB);
        classA.methodA();

    }
}
